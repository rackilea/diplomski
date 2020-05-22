/**
 * @author rodrigoap
 * 
 */
public class WebServiceUserDetailsAuthenticationProvider extends
    AbstractUserDetailsAuthenticationProvider {

  @Override
  protected UserDetails retrieveUser(String username,
        UsernamePasswordAuthenticationToken authentication)
        throws AuthenticationException {
     //Improve this line:
    String password = authentication.getCredentials().toString();
    // Invoke your webservice here
    GrantedAuthority[] grantedAuth = loginWebService.login(username, password);
    // create UserDetails. Warning: User is deprecated!
    UserDetails userDetails = new User(username, password, grantedAuth);
    return userDetails;
  }

}