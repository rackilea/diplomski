@Path("/helloWorld")
@Consumes({"application/xml", "application/json"})
@Produces({"application/xml", "application/json"})
@Singleton
public class MyService {
    @GET
    public String getRequest(@QueryParam("name") String name) {
            return "Name was " + name;
    }
}