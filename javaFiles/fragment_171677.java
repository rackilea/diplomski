public class ActorsServiceImpl extends ActorsService {  
    private ActorRef parentActor;
    @Inject
    public ActorsServiceImpl(@Named("parentActor") ActorRef parentActor) {
        this.parentActor = parentActor;
    }

    public CompletionStage<ActorRef> createSyncronizer(Long taskLogId, String clientGroup, boolean messagesOnly, String notes, String brandId) {
        // Use guice assisted injection to instantiate and configure the child actor.
        long timeoutMillis = 100L;
        return FutureConverters.toJava(
            ask(parentActor,  
                new SynchronizerParent.CreateSynchronizer(taskLogId, clientGroup, messagesOnly, notes),
                brandId), 
            timeoutMillis))
        .thenApply(response -> (ActorRef) response);
    }
}