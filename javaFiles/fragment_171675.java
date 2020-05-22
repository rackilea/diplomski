public class SynchronizerParent extends UntypedActor implements InjectedActorSupport {

    //Protocol
    public static class CreateSynchronizer {
        private final Long taskLogId;
        private final String clientGroup;
        private final boolean messagesOnly;
        private final String notes;
        private final String brandId;

        public CreateSynchronizer(
                Long taskLogId, String clientGroup, 
                boolean messagesOnly, String notes, String brandId) {
            this.taskLogId = taskLogId;
            this.clientGroup = clientGroup;
            this.messagesOnly = messagesOnly;
            this.notes = notes;
            this.brandId= brandId;
        }       
    }

    private Synchronizer.Factory childFactory;

    @Inject
    public SynchronizerParent(Synchronizer.Factory childFactory) {
        this.childFactory = childFactory;
    }

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof CreateSynchronizer) {
            injectSynchronizer((CreateSynchronizer)message);
        }
        else {
            unhandled(message);
        }       
    }

    private void injectSynchronizer(CreateSynchronizer injectMsg) {
        ActorRef child =  injectedChild(() -> childFactory.create(
            injectMsg.taskLogId, 
            injectMsg.clientGroup,
            injectMsg.messagesOnly,
            injectMsg.notes)
            , "child-" +injectMsg.brandId);
        sender().tell(child, self());
    }   
}