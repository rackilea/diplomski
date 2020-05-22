import play.mvc.Http;

class Service {

    public void something() {
        String username = Http.Context.current().session().get("username");

        // do something
    }
}