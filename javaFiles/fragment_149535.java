public class SecurityFilter extends OncePerRequestFilter
{

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException
    {
        String url = request.getRequestURL().toString();
        String accessToken = request.getHeader("Authorization");
        try
        {
            if (accessToken == null || accessToken.isEmpty())
            {
                throw new Exception(Status.UNAUTHORIZED.getStatusCode(), "Provided access token is either null or empty or does not have permissions to access this resource." + accessToken);
            }
            if (url.endsWith("/signin"))
            {
    //Don't Do anything
                filterChain.doFilter(request, response);
            }
            else
            {
    //AUTHORIZE the access_token here. If authorization goes through, continue as normal, OR throw a 401 unaurhtorized exception

                filterChain.doFilter(request, response);
            }
        }
        catch (Exception ex)
        {
            response.setStatus(401);
            response.setCharacterEncoding("UTF-8");
            response.setContentType(MediaType.APPLICATION_JSON);
            response.getWriter().print("Unauthorized");
        }
    }
}