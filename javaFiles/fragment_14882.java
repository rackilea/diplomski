import akka.actor.*;
import play.mvc.*;
import play.libs.Akka;
import play.libs.F.Promise;

import static akka.pattern.Patterns.ask;

public class Application extends Controller {

    public static Promise<Result> index() {
        // select some actor from your system
        ActorSelection actor = Akka.system().actorSelection("user/my-actor");

        // now ask the actor something and do something with the reply
        return Promise.wrap(ask(actor, "how are you?", 1000))
                      .map(response -> ok(response.toString()));
    }
}