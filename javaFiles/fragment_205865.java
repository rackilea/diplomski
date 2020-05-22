public class Application extends Controller {

    public static Result index() {
        if (YourStaticHelper.yourStaticMethod.isOk()) {
            return ok("It works!");
        }
        else {
            return forbidden("NO");
        }
    }

}