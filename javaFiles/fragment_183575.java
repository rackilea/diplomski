@POST
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public Response authenticateUser(Credentials credentials) {

    String username = credentials.getUsername();
    String password = credentials.getPassword();

    // Authenticate the user, issue a token and return a response
}