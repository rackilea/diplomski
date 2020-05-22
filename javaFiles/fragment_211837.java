@POST
@Path("/session")
@Produces(MediaType.TEXT_PLAIN)
public String login(@FormParam("username") String username, @FormParam("password") String password, @Auth Subject subject) {
    subject.login(new UsernamePasswordToken(username, password));
    return username;
}

@PUT
@Path("/logout")
@Produces(MediaType.TEXT_PLAIN)
public String logout(@Auth Subject subject){
    subject.logout();
    return "Successfully logged out!";
}