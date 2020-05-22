public void doGet(HttpServletRequest req, HttpServletResponse res) {
    String code = "";
    Enumeration paramEnum = req.getParameterNames();
    while (paramEnum.hasMoreElements()) {
    String name = (String) paramEnum.nextElement();
    if (name.equals("code")) {
        code = req.getParameter(name);
    }

    OAuthService service = new ServiceBuilder().provider(FacebookApi.class).apiKey(FACEBBOK_APP_KEY)
.apiSecret(FACEBOOK_APP_SECRET).callback(FACEBOOK_CALLBACK);
    Verifier verifier = new Verifier(code);
    //....
}