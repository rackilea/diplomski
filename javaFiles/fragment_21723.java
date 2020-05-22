protected User getUser(Http.Context ctx) {
    String token = ctx.request().getHeader("x-session-token");  

    if (token != null) {
        return securityService.validateToken(token);
    }
    return null;
}