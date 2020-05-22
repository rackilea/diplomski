import java.text.ParseException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException
    {
        try
        {            
            String db_file_name_prefix = "c:\\mydbdir\\mydb";

            Connection con = null;
            // Load the HSQL Database Engine JDBC driver
            // hsqldb.jar should be in the class path or made part of the current jar
            Class.forName("org.hsqldb.jdbcDriver");

            // connect to the database.   This will load the db files and start the
            // database if it is not alread running.
            // db_file_name_prefix is used to open or create files that hold the state
            // of the db.
            // It can contain directory names relative to the
            // current working directory
            con = DriverManager.getConnection("jdbc:hsqldb:file:" + db_file_name_prefix, // filenames
                    "sa", // username
                    "");  // password

            Statement statement = con.createStatement();
            //look at " for table name
            ResultSet rs = statement.executeQuery("SELECT * FROM \"User\"");

            //print the result set
            while (rs.next())
            {
                System.out.print("ID: " + rs.getString("ID"));
                System.out.print(" first name: " + rs.getString("firstname"));
                System.out.println(" last name: " + rs.getString("lastname"));
            }

            statement.close();
            con.close();

        } catch (SQLException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
            ex.printStackTrace();
        } catch (ClassNotFoundException ex)
        {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}