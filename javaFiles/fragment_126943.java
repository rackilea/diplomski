import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBConnect {

public static void main(String[] args) {
    try {
        Class.forName("com.mysql.jdbc.Driver").newInstance();
        System.out.println("Connecting to a selected database...");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "user", "pass");
        System.out.println("Connected database successfully...");
        Statement s = con.createStatement();
        String q = "select * from table";
        s.execute(q);
    } catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException ex) {
        Logger.getLogger(DBConnect.class.getName()).log(Level.SEVERE, null, ex);
    }
}
}