class MyController extends Controller {

    public Result action() {
        String username = session("username");
        service.something(username);
    }
}