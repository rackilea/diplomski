@Path("/userreg")
public class UserRegistration {

    User user;

    @Inject
    UserDao userDao;

    @GET
    @Produces({"application/json", "application/xml"})
    public User UserRegister() {
        user = new User();
        user.setUserName("u1");
        user.setPassword("p1");
        userDao.add(user);

        return user;
    }
}