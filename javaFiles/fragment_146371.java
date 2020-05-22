@Path("/profile")
public class ProfileService {
    @GET
    @Path("/{id}")
    public Profile getProfile(@PathParam("id") String id) {
        //...
    }