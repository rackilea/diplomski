private void getOAuth2AuthorizationUrl(HttpServletResponse response, HttpSession session)
{
  final String oauth2AuthorizationUrl = "http://localhost:8080/oauth/authorize?" +
   + "response_type=code"
   + "&client_id=client-with-registered-redirect" 
   + "&redirect_url=http://client_host?key=value"
   + "&scope=read"
      try {
          final PrintWriter writer = response.getWriter();
          writer.write(oauth2AuthorizationUrl);
          writer.flush();
      } catch (IOException e) {
          log.error("IO Exception : {}", e.getMessage());
      }
}