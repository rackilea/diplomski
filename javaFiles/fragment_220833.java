public class UserRegistrationServlet extends HttpServlet {

    @Inject
    private UserRequestExtractor userRequestExtractor;

    @Inject
    private UserRegistrationService userRegistrationService;

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException {
        PrintWriter pw = response.getWriter();
        pw.print(createResponse(userRequestExtractor.extract(request)));
    }

    protected String createResponse(User newUser) {
        if (newUser == null) {
            return "{'message' : 'the user parameters are not valid'}";
        }
        else {
            UserRegistrationResult result = userRegistrationService.register(newUser);
            switch (result) {
                case SUCCESS:
                    return "{'message' : 'hurray'}";
                case EMAIL_IN_USE:
                    return String.format("{'message' : 'the email address %s is already in use'}", newUser.email);
                case USERNAME_IN_USE:
                    return String.format("{'message' : 'the user name %s is already in use'}", newUser.username);
                default:
                    return "{'message' : 'an error occurred'}";
            }
        }
    }
}

public class User {
    private String username;
    private String email;

    public boolean isValid() {
        return username != null && email != null;
    }
}

/**
 * Extractor which instantiates an object of type T from a request
 * 
 * @param <T>
 */
public interface RequestExtractor<T> {
    public T extract(HttpServletRequest request);
}

public class UserRequestExtractor implements RequestExtractor<User> {
    public User extract(HttpServletRequest request) {
        User user = new User();
        user.username = request.getParameter("username");
        user.email = request.getParameter("email");
        // validation could also be a responsibility of the RequestExtractor
        if (!user.isValid()) {
            return null;
        }
        return user;
    }
}

public interface UserRegistrationService {
    public UserRegistrationResult register(User user);
}

// implementation of UserRegistrationService omitted

public enum UserRegistrationResult {
    SUCCESS, EMAIL_IN_USE, USERNAME_IN_USE;
}

/**
 * Unit test
 */
public class UserRegistrationServletTest {

    @Test
    public void test() {
        UserRegistrationServlet cut = new UserRegistrationServlet();
        User user = new User();
        user.username = null;
        user.email = "test@test.test";

        String response = cut.createResponse(user);

        Assert.assertEquals("{'message' : 'the user parameters are not valid'}", response);
    }
}