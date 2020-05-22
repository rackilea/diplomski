public class OAuth2AuthorizationCodeServlet 
    extends AbstractAuthorizationCodeServlet {
    /**
     * If the user already has a valid credential held in the 
     * AuthorizationCodeFlow they are simply returned to the home page.
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
                    throws ServletException, IOException {
        response.sendRedirect("/");
    }

    /**
     * Returns the URI to redirect to with the authentication result.
     */
    @Override
    protected String getRedirectUri(HttpServletRequest request)
                    throws ServletException, IOException {
        return ConfigHelper.REDIRECT_URI;
    }

    /**
     * Returns the HTTP session id as the identifier for the current user.  
     * The users credentials are stored against this ID.
     */
    @Override
    protected String getUserId(HttpServletRequest request)
                    throws ServletException, IOException {
        return request.getSession(true).getId();
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() throws ServletException,
                    IOException {
        return Util.getFlow();
    }
}