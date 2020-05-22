@Path("/")
public class UserService {

  @GET
  @Produces(MediaType.APPLICATION_XML)
  @Path("/{id}")
  public User getUser(@PathParam("id") String id) {
    //Your implementation here
  }

}