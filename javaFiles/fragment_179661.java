@Path("/v1/status")
public class ControllerServices 
{
    @GET
    @Path("print")
    @Produces(MediaType.TEXT_HTML)
    public String printOnly()
    {
        System.out.println("running successfully");
        return "<p>this webservice</p>";
    }
}