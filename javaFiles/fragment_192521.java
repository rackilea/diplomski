ISVNAuthenticationManager authManager = 
  new BasicAuthenticationManager(new SVNAuthentication[] {
        new SVNPasswordAuthentication(userName, password, 
                                      false, url, false),
  });
repository.setAuthenticationManager(authManager);