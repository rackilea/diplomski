public class RetConfig {     
    String urlValue;
    String userValue;
    String pwdValue;

    public void retConfig( ) {
        Properties prop = new Properties();
        try  (InputStream input = new FileInputStream("resources/config.properties")) {
            prop.load(input);
            this.urlValue = prop.getProperty("url");
            this.userValue = prop.getProperty("user");
            this.pwdValue = prop.getProperty("password");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}