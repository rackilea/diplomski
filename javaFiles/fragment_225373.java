@GET
@Produces(MediaType.APPLICATION_JSON)
public String list();

@GET
@Path("/loggedInUser")
@Produces(MediaType.APPLICATION_JSON)
public String getUser();