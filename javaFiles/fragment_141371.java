import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.UntypedActor;

public class TestAkka {

    public static void main(String[] args) throws InterruptedException {
        ActorSystem as1 = ActorSystem.create("actor1");
        ActorRef ar1 = as1.actorOf(Props.create(Hello.class));
        ActorRef ar2 = as1.actorOf(Props.create(Hello.class));
        System.out.println("Start to say hello!");
        ar1.tell("Bob", ActorRef.noSender());
        ar2.tell("John", ActorRef.noSender());
        System.out.println("Finish to say hello!");
    }

    public static class Hello extends UntypedActor {

        @Override
        public void onReceive(Object message) throws Exception {
            if (message instanceof String) {
                System.out.println("Hello " + message);
                Thread.sleep(10000);  // <--Sim the job take a short time
            }
        }
    }
}