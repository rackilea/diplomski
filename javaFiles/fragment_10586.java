@Component
public class CustomAuthenticationProvider implements AuthenticationProvider{


@Override
public Authentication authenticate(Authentication auth) throws AuthenticationException {
String userName = auth.getName().trim();
String password = auth.getCredentials().toString().trim();
String companyName = ((ExtraParam)auth.getDetails()).getCompanyName();

....