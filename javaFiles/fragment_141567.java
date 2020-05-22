public class Main {

public static void main(String[] args) {

    // Create the ‘actorTest’ actor system.
    final ActorSystem system = ActorSystem.create("actorTest");

    // Create the actors.
    ActorRef ActorRefA = system.actorOf(Props.create(ActorA.class));
    ActorRef ActorRefB = system.actorOf(Props.create(ActorB.class));

   // Inject ActorRefs
   ActorRefA.tell(ActorRefB, ActorRef.noSender());
   ActorRefB.tell(ActorRefA, ActorRef.noSender());

    // Send a message to ActorA.
    ActorRefA.tell("message A", ActorRefA);

 }

}