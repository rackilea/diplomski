import java.util.*;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.*;
import org.springframework.security.core.*;
import org.springframework.stereotype.Component;
import com.restfb.*;;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
    private @Autowired HttpServletRequest request;

    @Override
    public Authentication authenticate(Authentication authentication) {
        String fb_access_token = String.valueOf(request.getParameter("fb_access_token"));

        //fb user
        Authentication auth = null;
        try {
            FacebookClient fbClient = new DefaultFacebookClient(fb_access_token);
            User user = fbClient.fetchObject("me",com.restfb.types.User.class);
            String email = user.getEmail();
            String gender = user.getGender();
            String pic = "http://graph.facebook.com/" + user.getId() + "/picture?type=normal"; 
            //Your DB implementation

        } catch (Exception e) {
            throw new FacebookOAuthException("FB","OAuth",5002, null, null, "", "");
        }       
    }
}