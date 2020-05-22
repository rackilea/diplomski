public class Application extends Controller {

    @Inject
    YourStaticHelperInterface checker;

    public Result index() {  // no longer static
        if (checker.isOk()) {
            return ok("It works!");
        }
        else {
            return forbidden("NO");
        }
    }

}