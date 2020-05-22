import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.dispatch.*;
import akka.dispatch.Future;
import akka.pattern.Patterns;
import akka.util.Duration;
import akka.util.Timeout;

public class Client{

    public static void main(String[] args){
        ActorSystem actorSystem = ActorSystem.create("HelloWorldSystem");
        ActorRef listener = actorSystem.actorOf(new Props(HelloActor.class), "listener");

        Timeout timeout = new Timeout(Duration.create(5, "seconds"));
        Future<Object> future = Patterns.ask(listener, "Hello", timeout);

        try{
            String result = (String) Await.result(future, timeout.duration());
            System.out.println(result);

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}