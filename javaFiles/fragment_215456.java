@POST
@Consumes("application/xml")
@Produces("application/xml")
public Response post(User user) {
    return user;
}