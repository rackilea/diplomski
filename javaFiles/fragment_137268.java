public class OAuth2CallbackServlet 
    extends AbstractAuthorizationCodeCallbackServlet {    
    @Override
    protected void onSuccess(HttpServletRequest request, 
            HttpServletResponse response, Credential credential)
            throws ServletException, IOException {
        response.sendRedirect("/");
    }

    @Override
    protected void onError(HttpServletRequest req, HttpServletResponse resp, 
            AuthorizationCodeResponseUrl errorResponse)
            throws ServletException, IOException {
        resp.sendError(SC_INTERNAL_SERVER_ERROR, "Something went wrong :(");
    }

    @Override
    protected String getRedirectUri(HttpServletRequest request) 
            throws ServletException, IOException {
        return ConfigHelper.REDIRECT_URI;
    }

    @Override
    protected AuthorizationCodeFlow initializeFlow() 
            throws IOException {
        return Util.getFlow();
    }

    @Override
    protected String getUserId(HttpServletRequest request) throws ServletException, IOException {
        return  request.getSession(true).getId(); 
    }

}