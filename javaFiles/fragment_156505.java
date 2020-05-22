@SubjectPresent(content = "login")
public class FooController extends Controller {

    public Result settings() {
        // ...
    }

    public Result somethingElse() {
        // ...
    }

    @SubjectPresent(content = "create-user")
    public Result viewUser() {
        // ...
    }
}