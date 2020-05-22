@Component
public class MyAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
    {
        UsernamePasswordAuthenticationToken authToken = null;

        if ("user".equals(request.getParameter("userType"))) 
        {
            authToken = new UserUsernamePasswordAuthenticationToken(request.getParameter("userName"), request.getParameter("password"));
        }
        else 
        {
            authToken = new AdminUsernamePasswordAuthenticationToken(request.getParameter("userName"), request.getParameter("password"));
        }

        setDetails(request, authToken);

        return super.getAuthenticationManager().authenticate(authToken);
    }
}