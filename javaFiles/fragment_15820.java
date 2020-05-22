public class MyCustomUserDetailsService implements UserDetailsService {

    private UserDAO userDAO;

    public MyCustomUserDetailsService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }
    // ...    
}