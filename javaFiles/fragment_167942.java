@PUT
@Path("/login")
@Produces({ "application/json", "text/plain" })
@Consumes("multipart/form-data")
public String login(@FormParam("login") String login,
        @FormParam("password") String password) {
    String response = null;
    response = new UserManager().login(login, password);
    return response;
}