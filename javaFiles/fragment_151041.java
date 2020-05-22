@Service("nullAuthenticationProvider")
public class NullAuthenticationProvider implements AuthenticationProvider
{
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException
    {
        return authentication;
    }

    @Override
    public boolean supports(Class<?> authentication)
    {
        return true;
    }
}