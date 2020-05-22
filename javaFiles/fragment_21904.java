@Path("secure")
public class SecuredResource {
    @GET
    @RolesAllowed({"ADMIN"})
    public String getUsername(@Context SecurityContext securityContext) {
        User user = (User)securityContext.getUserPrincipal();
        return user.getName();
    }
}