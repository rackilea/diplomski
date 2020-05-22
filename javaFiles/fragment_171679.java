public class ActorsServiceImpl extends ActorsService {
    ...
    public ActorRef createSynchronizer(Long taskLogId, String clientGroup, 
        boolean messagesOnly, String notes, String brandId) {
    return getActorSystem().actorOf(Synchronizer.props(
            taskLogId, clientGroup, messagesOnly, notes), 
            "ImageGenerator-" + brandId);       
    }
}