SocialAuthConfig config = SocialAuthConfig.getDefault();
  config.load(); // load your keys information 
  SocialAuthManager manager = new SocialAuthManager();
  manager.setSocialAuthConfig(config);

  String successUrl = "http://localhost:8080/yourapp/status
  String url = manager.getAuthenticationUrl("facebook", successUrl);
  session.setAttribute("authManager", manager);