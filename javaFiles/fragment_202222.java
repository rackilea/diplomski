import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


 DBConnection() throws SQLException, ClassNotFoundException {

            url = "jdbc:mysql://localhost/(your DB name)";

            user = "your user";

            password = "your password";

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(url, user, password);
        }