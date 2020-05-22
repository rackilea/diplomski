import akka.actor.*;
import play.mvc.*;
import play.libs.Akka;
import play.libs.F.Promise;

import static akka.pattern.Patterns.ask;

public class Application extends Controller {

    public static Result index() {
        // select some actor from your system
        ActorSelection actor = Akka.system().actorSelection("user/my-actor");

        // now tell the actor something and do something else because we don't get a reply
        actor.tell("Something");
        return ok("Hello");
    }
}