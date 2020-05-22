@POST
@Path("/authenticate")
@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
public void authenticate(@FormParam("email") String email, @FormParam("password") String password) throws Exception {

    if (loginService.authenticate(email, password)) {
        response.sendRedirect("/app");
    } else {
        request.setAttribute("authenticationError", "Invalid email/password.");

    }
}