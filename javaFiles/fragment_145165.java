import java.sql.Connection;
import java.sql.SQLException;


public class SecureDataSource extends DriverManagerDataSource{

    private String url;
    private String username;
    private String password;
    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    protected Connection getConnectionFromDriverManager() throws SQLException {
        String decryptedPassword = null;
        //decrypt the password here
        return getConnectionFromDriverManager(url,username,decryptedPassword);
    }
}