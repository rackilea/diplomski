public class MyServerResource extends ServerResource {
    @Post
    public Representation handleForm(Representation entity) {
        Form form = new Form(entity);

        // The form contains input with names "user" and "password"
        String user = form.getFirstValue("user");
        String password = form.getFirstValue("password");

        (...)
    }
}