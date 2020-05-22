import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Jdbc {

    public static void main(String args[]) {



        FileInputStream in = null;
        Connection con = null;
        try {

            Properties props = new Properties();
            in = new FileInputStream("/external/configuration/dir/db.properties");
            props.load(in);
            in.close();
            String driver = props.getProperty("jdbc.driver");
            if (driver != null) {
                Class.forName(driver);
            }
            String url = props.getProperty("jdbc.url");
            String username = props.getProperty("jdbc.username");
            String password = props.getProperty("jdbc.password");
            con = DriverManager.getConnection(url, username, password);
        } catch (Exception ex) {
            Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ex) {
                    Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            if (con != null) {
                try {
                    con.close();
                } catch (Exception ex) {
                    Logger.getLogger(Jdbc.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }
}