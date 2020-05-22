final String rpcuser ="...";
final String rpcpassword ="...";

Authenticator.setDefault(new Authenticator() {
  protected PasswordAuthentication getPasswordAuthentication() {
      return new PasswordAuthentication (rpcuser, rpcpassword.toCharArray());
  }});