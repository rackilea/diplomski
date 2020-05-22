public void doFilter(ServletRequest req,
                     ServletResponse res,
                     FilterChain chain) {
  if (request instanceof HttpServletRequest) {
    HttpServletRequest request = (HttpServletRequest) req;
    String authHeader = Base64.decode(request.getHeader("Authorization"));
    String creds[] = authHeader.split(":");
    String username = creds[0], password = creds[1];
    // Verify the credentials here...
    if (authorized) {
      chain.doFilter(req, res, chain);
    } else {
      // Respond 401 Authorization Required.
    }
  }
  doFilter(req, res, chain);
}