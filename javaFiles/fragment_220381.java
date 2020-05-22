public class AdminUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken
{   
    public AdminUsernamePasswordAuthenticationToken(Object principal, Object credentials)
    {
        super(principal, credentials);
    }

    public AdminUsernamePasswordAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities)
    {
        super(principal, credentials, authorities);
    }
}

public class UserUsernamePasswordAuthenticationToken extends UsernamePasswordAuthenticationToken
{
    public UserUsernamePasswordAuthenticationToken(Object principal, Object credentials)
    {
        super(principal, credentials);
    }

    public UserUsernamePasswordAuthenticationToken(Object principal, Object credentials,
            Collection<? extends GrantedAuthority> authorities)
    {
        super(principal, credentials, authorities);
    }}