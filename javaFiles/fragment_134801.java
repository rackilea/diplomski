/** This code will throw an Exception if the authentication fails */
public void postOAuthToken(HttpServletRequest request, HttpServletResponse response) {
    Application application = client.getResource(applicationRestUrl, Application.class);

    //Getting the authentication result
    AccessTokenResult result = (AccessTokenResult) application.authenticateApiRequest(request);

    //Here you can get all the user data stored in Stormpath
    Account account = accessTokenResult.getAccount();

    response.setStatus(HttpServletResponse.SC_OK);
    response.setContentType("application/json");

    //Output the json of the Access Token
    response.getWriter().print(token.toJson());
    response.getWriter().flush();
}