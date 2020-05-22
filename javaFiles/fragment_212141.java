@Stateless
    @Path("/login")
    public class LoginResource

    public Response login(Credentials credentials) {
    Credentials result = this.loginService.login(credentials);
            return Response.status(Response.Status.OK).entity(result).build();
     }