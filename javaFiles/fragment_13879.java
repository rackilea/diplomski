private static void setCredentials(WebClient webClient)
  {
    String username = "user";
    String password = "password";
    String base64encodedUsernameAndPassword = base64Encode(username + ":" + password);
    webClient.addRequestHeader("Authorization", "Basic " + base64encodedUsernameAndPassword);
  }

  private static String base64Encode(String stringToEncode)
  {
    return DatatypeConverter.printBase64Binary(stringToEncode.getBytes());
  }