@Path("/user/")
@Named
public class UserResource {

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Result<Users> get(@AttributeParam("foo") @PathParam("id") Users user) {
    ...
    }

}