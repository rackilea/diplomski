if (req.getRequestURI().equals("/twitter")) {
    Token requestToken = service.getRequestToken();
    System.out.println("Got the Request Token!" + requestToken.getToken());
    session = request.getSession(true);
    session.setAttribute("TOKEN", requestToken);
    response.sendRedirect(service.getAuthorizationUrl(requestToken));
} else if (req.getRequestURI().equals("/twitter/callback")) {
    String code = request.getParameter("oauth_verifier");
    System.out.println("Verifier :: " + code);
    System.out.println("service.getRequestToken()" + service.getRequestToken());
    session = request.getSession(false);
    Token requestToken = (Token) session.getAttribute("TOKEN");
    System.out.println("requestToken from Session " + service.getRequestToken().getToken() + " Secr" + service.getRequestToken().getSecret());

    if (code != null && !code.isEmpty()) {
        Verifier verifier = new Verifier(code);
        Token accessToken = service.getAccessToken(requestToken, verifier);
        OAuthRequest req = new OAuthRequest(Verb.GET, OAUTH_PROTECTED_URL);
        service.signRequest(accessToken, req);
        Response res = req.send();
        response.setContentType("text/plain");
        response.getWriter().println(res.getBody());
    }
}