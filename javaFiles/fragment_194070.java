public class MyPreAuthenticatedProcessingFilter
    extends AbstractPreAuthenticatedProcessingFilter {

  public MyPreAuthenticatedProcessingFilter(
      AuthenticationManager authenticationManager) {
    setAuthenticationDetailsSource(new MyAuthenticationDetailsSource());
  }

  @Override
  protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {
    return "Anonymous";
  }

  @Override
  protected Object getPreAuthenticatedCredentials(HttpServletRequest request) {
    return "N/A";
  }

  public static class MyAuthenticationDetailsSource implements 
      AuthenticationDetailsSource<HttpServletRequest, MySessionUserDetails> {
    // roles probably should be encrypted somehow
    static final String ROLES_PARAMETER = "pre_auth_roles";

    @Override
    public MySessionUserDetails buildDetails(HttpServletRequest req) {
      // create container for pre-auth data
      return new MySessionUserDetails(req.getParameter(ROLES_PARAMETER));
    }
  }
}