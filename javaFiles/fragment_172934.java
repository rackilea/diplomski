private  BasicAuthenticator() {
    // TODO Auto-generated constructor stub
}
public static BasicAuthenticator THIS = new BasicAuthenticator();

public static Authenticator getAutheticator(){
    return THIS;
}
  final static String USERNAME = "";
  final static String PASSWORD = "";

  @Override
  public PasswordAuthentication getPasswordAuthentication() {

    return new PasswordAuthentication(USERNAME, PASSWORD.toCharArray());
  }