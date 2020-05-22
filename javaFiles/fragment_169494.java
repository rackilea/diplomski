@Path("rest/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserService {

  @POST
  @Path("/login")
  public Response login(
        @FormParam("username") String username,
        @FormParam("password") String password
  ) {
      // Your logic here
  }
}