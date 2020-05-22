@Component(immediate = true)
@Service(value = WorkflowProcess.class)
public class ReplicateUsergeneratedContentToPublishWorkflow extends     AbstractAuthorToPublishWorkflow implements WorkflowProcess{
// OSGI properties
@Property(value = "This workflow replicate usergenerated content from author to publisher")
static final String DESCRIPTION = Constants.SERVICE_DESCRIPTION;

@Property(value = "Titel")
static final String VENDOR = Constants.SERVICE_VENDOR;

@Property(value = "Replicate the usergenerated content from one publisher via author to the ohter publisher")
static final String LABEL = "process.label";

private static final Logger LOGGER = LoggerFactory.getLogger(ReplicateUsergeneratedContentToPublishWorkflow.class);

@Reference
private ResourceResolverFactory resolverFactory;

@Reference
protected Replicator replicator;

@Reference
private SlingRepository repository;

@Reference
SlingSettingsService slingSettingsService;
@Override
public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
    Session session = null;
    SimpleCredentials administrator = new SimpleCredentials("username", "password".toCharArray());
    try {
        java.util.Set<String> runModes = slingSettingsService.getRunModes();
        session = repository.login(administrator);
        //the replication need to check the payload
        String payload = workItem.getWorkflowData().getPayload().toString();
        Node node = null;
        if (session.itemExists(payload)) {
            node = (Node) session.getItem(payload);
        }

        activateNode(node, workflowSession, replicator);
        //save all changes
        session.save();
    } catch (PathNotFoundException e) {
        LOGGER.error("path not found", e);
        workflowSession.terminateWorkflow(null);
    } catch (ReplicationException e) {
        LOGGER.error("error replicating content node", e);
        workflowSession.terminateWorkflow(null);
    } catch (RepositoryException e) {
        LOGGER.error("error reading path to content node", e);
        workflowSession.terminateWorkflow(null);
    }finally{
        if(session != null){
            session.logout();
        }
    }
}
}


public abstract class AbstractAuthorToPublishWorkflow implements WorkflowProcess {

protected void activateNode(Node node, WorkflowSession workflowSession, Replicator replicator) throws RepositoryException, ReplicationException {
    ReplicationOptions replicationOptions = new ReplicationOptions();
    replicationOptions.setSuppressStatusUpdate(true);
    replicationOptions.setSuppressVersions(true);
    //replicationOptions.setSynchronous(true);

    //the property cq:distribute is settet if the node should be replicated from publisher to author (set it in your own code)
    if (node != null) {
        node.setProperty("cq:distribute", (Value) null);

        //important use WorkflowSession and adapt it to Session class, replication is going to an endless loop, if you doing it without WorkflowSession
        replicator.replicate(workflowSession.adaptTo(Session.class), ReplicationActionType.ACTIVATE, node.getPath(), replicationOptions);
    }
}
}