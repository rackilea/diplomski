public class ActorA extends UntypedActor {

    private ActorRef actorRefB;

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("ActorA received: " + message);

        if (message instanceof ActorRef) {
            actorRefB = message;
        } else if (message instanceof String) {
            // This is the line which I can't get to work:
            actorRefB.tell("message B", self());
        }

    }

}