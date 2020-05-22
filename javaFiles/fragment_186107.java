@Component
public class SecurityCheck {


public boolean check(User user, Authentication authentication) {
    if(user == null)
        return false;
   if(user.getId().equals(authentication.getName()))    
       return true;
   // more logic ... 
   return false;
 }
}