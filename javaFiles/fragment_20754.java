private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

@Override
public void onAuthenticationSuccess(HttpServletRequest request, 
  HttpServletResponse response, Authentication authentication) throws IOException {
    //Your custom stuff
    handle(request, response, authentication);
}

protected void handle(HttpServletRequest request, 
    HttpServletResponse response, Authentication authentication) throws IOException {
    String targetUrl = "";//Place your target url detection logic here. 

    redirectStrategy.sendRedirect(request, response, targetUrl);
}