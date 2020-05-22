import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import play.db.ebean.Model;
public class Client extends Model {

    /**
     * 
     */
    private static final long serialVersionUID = -1932214701504374792L;
    public static String ClientName;
    public static HashMap<String, String> Clientdetail= new HashMap<String, String>();
    public static HashMap<String, String> getClientDetails() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver").newInstance();
            Connection conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433","SUMEET","sumeet");
            Statement sta = conn.createStatement();
            String Sql = "select * from client";
            ResultSet rs = sta.executeQuery(Sql);
            while (rs.next()) {
                ClientName = rs.getString("ClientName");
                Clientdetail.put(ClientName,ClientName);
               }

        } catch (InstantiationException | IllegalAccessException
                | ClassNotFoundException |SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return(Clientdetail);

    }

}