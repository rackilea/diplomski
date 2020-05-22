@Path("/hash")
public class HashController
{
    @PUT @Produces("text/plain")
    @Path("{path: .+}")
    public String m1(@PathParam("path") String path) {
        return "m1 called with path " + path;
    }

    @GET @Produces("text/plain")
    @Path("{path: [\\w\\-]+}")
    public String m2(@PathParam("path") String path) {
        return "m2 called with path " + path;
    }
}