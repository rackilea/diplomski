public class ActorA extends UntypedActor {

    @Override
    public void onReceive(Object message) throws Exception {
        System.out.println("ActorA received: " + message);

        ActorSelection actorB = getContext().actorSelection("../actorB");
        actorB.tell("message B", self());

    }

}