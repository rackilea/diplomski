@GET
@Path("/getUser")
@Produces("application/xml; charset=UTF-8")
public User getUser(@QueryParam("userId") int userId) {
    return User.load(userId);
}