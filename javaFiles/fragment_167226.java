import play.*;
import play.mvc.*;

import views.html.*;
import foo.bar.*;

public class Application extends Controller {

    public static Result index() {
        return ok(index.render("Your new application is ready."));
    }
}