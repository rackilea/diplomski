public void doGet(HttpServletRequest req, HttpServletResponse res) {
    OAuthService service = new ServiceBuilder().provider(FacebookApi.class).apiKey(FACEBBOK_APP_KEY)
.apiSecret(FACEBOOK_APP_SECRET).callback(FACEBOOK_CALLBACK);
    String authenticationUrl = service.getAuthorizationUrl(null);
    res.sendRedirect(authenticationUrl);
}