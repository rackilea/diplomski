public class FacultyServerResource extends ServerResource {
    @Get ("json")
    public String present() throws Exception {
        String facultyName = (String)getAttribute("name");
        (...)
    }