@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
public class UserResource {
    private final UserDAO dao;

    public UserResource(UserDAO userDAO)
    {
        dao = userDAO;
    }

    @GET
    @UnitOfWork
    @JsonView(View.Public.class)
    @RolesAllowed("beheerder")
    public List<User> retrieveAll(@Auth User user)
    {
        List<User> users = dao.findAll();
        for (User u: users) {
            Hibernate.initialize(u.getRoles());
        }
        return users;
    }

    // Some other routes..
}