import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.EmptyStackException;

public class SingletonConnection   {


    private static Connection connection = null ;
    static 
    {
        try{
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection
                    ("jdbc:mysql://localhost:3306/dbnameX","root","");
        }catch(Exception ex)
        {

        }

    }
    public static Connection getConnection() throws Exception {
        return connection;
    }


}