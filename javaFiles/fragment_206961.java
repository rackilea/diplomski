public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    String authHeader = request.getHeader("Authorization");

    if (authHeader != null && authHeader.startsWith("Basic ")) {
        String[] up = parseBasic(authHeader.substring(authHeader.indexOf(" ") + 1));
        String username = up[0];
        String password = up[1];
        if (authenticateUser(username, password)) {
            super.handle(target, baseRequest, request, response);
            return;
        }
    }

    response.setHeader("WWW-Authenticate", "BASIC realm=\"SecureFiles\"");
    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Please provide username and password");
}

private boolean authenticateUser(String username, String password) {
    // Perform authentication here
    return true; // .. if authentication is successful
}

private String[] parseBasic(String enc) {
    byte[] bytes = Base64.decodeBase64(enc.getBytes());
    String s = new String(bytes);
    int pos = s.indexOf( ":" );
    if( pos >= 0 )
        return new String[] { s.substring( 0, pos ), s.substring( pos + 1 ) };
    else
        return new String[] { s, null };
}