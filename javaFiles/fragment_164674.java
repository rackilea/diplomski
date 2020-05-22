package controllers;

import java.util.Date;
import play.mvc.*;

import views.html.*;

public class HomeController extends Controller {
    public Result index() {
        return ok(index.render(new Date()));
    }
}