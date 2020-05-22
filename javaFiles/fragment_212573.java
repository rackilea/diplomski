@Path("User")
public class UserResource {
    @EJB
    private UserappDAO userDAO;


    @GET
    @JWTTokenNeeded(Permissions = Role.Admin)
    @Produces("application/json")
    public List<Userapp> all() {
        return userDAO.getAll();
    }
}