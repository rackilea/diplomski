package controllers;

import play.mvc.Controller; // no .api.
import play.mvc.Result; // no .api.

public class Application extends Controller {
    public Result index() {
        return ok(views.html.index("Your new application is ready."));
    }
}