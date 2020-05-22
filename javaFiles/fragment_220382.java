@Component
public class AdminCustomAuthenticationProvider implements AuthenticationProvider
{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        if (username.equals("admin") && password.equals("admin@123#"))
        {
            List<GrantedAuthority> authorityList = new ArrayList<>();
            GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_ADMIN");
            authorityList.add(authority);

            return new UserUsernamePasswordAuthenticationToken(username, password, authorityList);
        }
        return null;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return authentication.equals(AdminUsernamePasswordAuthenticationToken.class);
    }
}