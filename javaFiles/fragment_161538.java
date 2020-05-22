@Reference
        private RolloutManager rolloutManager;
        @Reference
        private ResourceResolverFactory resourceResolverFactory;

        private Session session;
        private ResourceResolver resolver;
        private PageManager pageManager;

        public class MyWorkflow implements WorkflowProcess {
            @Override
            public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap dataMap) throws WorkflowException {
               //get the payload page from the workflow data
               WorkflowData workflowData = workItem.getWorkflowData();
               String payload = workflowData.getPayload().toString();

               final Map<String, Object> authInfo = new HashMap<String, Object>();
               authInfo.put(JcrResourceConstants.AUTHENTICATION_INFO_SESSION, workflowSession.getSession());
               resolver = resourceResolverFactory.getResourceResolver(authInfo);

               //Get Instance of PageManager
               pageManager = resolver.adaptTo(PageManager.class);
               final Page targetPage = pageManager.getPage(payload);

               final RolloutParams params = new RolloutParams();
               params.isDeep = false;
               params.master = targetPage;
               params.reset = false;
               params.trigger = RolloutManager.Trigger.ROLLOUT;
               params.delete = false;
               rolloutManager.rollout(params);

            }
        }