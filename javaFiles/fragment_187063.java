@Singleton
public class OnStartup {

    @Inject
    public OnStartup(final UserService userService) {
        if (userService.findUserByEmail("email@company.com") == null) {
            String email = "email@company.com";
            String password = "1234";
            String fullName = "My Name";
            User user = new User();
            user.password = BCrypt.hashpw(password, BCrypt.gensalt());
            user.full_name = fullName;
            user.email = email;
            user.save();
        }
    }
}