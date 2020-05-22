class HttpResponseAuthenticationFilter extends RememberMeAuthenticationFilter {

  protected  void   onSuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, Authentication authResult) {
    super.onSuccessfulAuthentication(request, response, authResult);
    if (authResult != null) {
      response.setStatus(HttpServletResponse.SC_OK);
    }
  }

}