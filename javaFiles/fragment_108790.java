//"constants" for fake auth values
   private static final String user = "MyUser";
   private static final String token = "MyTokenString";

   //TokenServices to validate/convert ISAM Bearer Token
   @MockBean ResourceServerTokenServices tokenServices;

   private Authentication setAuth() throws Exception
   {
      UsernamePasswordAuthenticationToken auth =
              new UsernamePasswordAuthenticationToken(user, token,
                                                      Collections.emptyList());

      if (!auth.isAuthenticated()) { fail("NOT AUTHENTICATED!"); }

      SecurityContextHolder.getContext().setAuthentication(auth);

      DefaultOAuth2AccessToken mockTokenImpl = new DefaultOAuth2AccessToken(user);
      mockTokenImpl.setScope(Collections.singleton("authenticate:applications"));
      mockTokenImpl.setTokenType("Bearer");

      when(tokenServices.readAccessToken(anyString())).thenReturn(mockTokenImpl);

      OAuth2Authentication oa2Auth = mock(OAuth2Authentication.class);
      when(oa2Auth.getPrincipal()).thenReturn(user);
      when(oa2Auth.getCredentials()).thenReturn(token);
      when(oa2Auth.getUserAuthentication()).thenReturn(auth);
      when(oa2Auth.isAuthenticated()).thenReturn(true);

      OAuth2Request oa2Req = mock(OAuth2Request.class);
      when(oa2Auth.getOAuth2Request()).thenReturn(oa2Req);

      when(tokenServices.loadAuthentication(anyString())).thenReturn(oa2Auth);

      return auth;
   }