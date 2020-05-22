import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.mycompany.lts.entities.UserDetail;
import com.mycompany.lts.exception.MyException;
import com.mycompany.lts.service.UserService;
public class UserAuthenticator implements UserDetailsService {
@Autowired
private UserService userService;
@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
UserDetail entity = null;
System.out.println(" LOAD BY USER NAME ---- LOADING USERS ");
try {
entity = userService.getUserByUserName(username);
} catch (MyException e) {
e.printStackTrace();
}
GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_USER");
UserDetails userDetails = (UserDetails) new User(entity.getUserName(), entity.getPassword(),
Arrays.asList(authority));
return userDetails;
}

}