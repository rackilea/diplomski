@Override
public void onAuthenticationSuccess(HttpServletRequest request, 
  HttpServletResponse response, Authentication authentication) throws IOException {
    handle(request, response, authentication);
    clearAuthenticationAttributes(request);
}