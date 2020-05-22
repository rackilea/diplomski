public class Main {

    public static void main(String[] args) {

        // Create the ‘actorTest’ actor system.
        final ActorSystem system = ActorSystem.create("actorTest");

        // Create the actors.
        ActorRef ActorRefA = system.actorOf(Props.create(ActorA.class), "actorA");
        ActorRef ActorRefB = system.actorOf(Props.create(ActorB.class), "actorB");

        // Send a message to ActorA.
        ActorRefA.tell("message A", ActorRefA);

     }

}