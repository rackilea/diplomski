@POST
@Path("updateUser")
@Consumes(value = { MediaType.APPLICATION_JSON })
@Produces(value = { MediaType.APPLICATION_JSON })
public Response updateUser(NewCorporateUserRequest req) throws UnknownHostException {
      User user;
      user = new CorporateUser(req.getName(), req.getSurname(), req.getAddress()); 
      usersService.updateUser(user);
      return Response.ok().entity(user).type(MediaType.APPLICATION_JSON).build();
}

public class NewCorporateUserRequest implements java.io.Serializable {

    private String name;
    private String surname;
    private String address;

    ... Getters and Setters.

}