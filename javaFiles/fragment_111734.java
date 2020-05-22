public class Config {
  public static String admin_username;

  static {
    Properties props = ...;
    admin_username = props.getProperty("admin.username");
  }
}