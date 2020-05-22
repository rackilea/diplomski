// Adding this import to demontrate where "User" is coming from
import org.springframework.security.core.userdetails.User;

public class MyUserDetailsService implements UserDetailsService {

    @Override
    public User loadUserByUsername(String username) {
        return new User(username, getPassword(username), Arrays.asList(new SimpleGrantedAuthority("USER")));
    }

    private String getPassword(String username) {
        // Get password from your XML
    }
}