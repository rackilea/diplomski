public class MyServerResource extends ServerResource {
    @Get
    public Representation handleGet() {
        String projectName = getAttribute("projectName");
        String wallName = getAttribute("wallName");
        (...)
    }
}