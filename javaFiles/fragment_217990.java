private String getAuthenticationUser()
  {
    String authorization = context.getHeader("authorization");
    if (authorization.startsWith("Digest response")) {
      String[] splits = authorization.split(",");
      for (String split : splits)
      {
        String[] splitKeyValue = split.trim().split("=");
        if(splitKeyValue[0].equalsIgnoreCase("username")) {
          authorization = splitKeyValue[1];
          authorization = authorization.replace("\"", "");
          break;
        }
      }
    }
    return authorization;
  }