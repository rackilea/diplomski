package controllers;

import play.*;
import play.mvc.*;

// This lets you call the template without the views.html prefix
// import views.html.*;
import views.txt.*;

public class Greeter extends Controller {

  public static Result say(String message) {
    return ok(greeter.render(message));
  }

}