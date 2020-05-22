public class Application extends Controller {
  public static Result login() {
    session("key", "example value");
    return ok("Welcome!");
  }
}