import java.util.ArrayList;
import java.sql.*;

public class OracleConnection {

    public static void main(String[] args) throws Exception {
        //connect to database
        Class.forName("oracle.jdbc.driver.OracleDriver");
        ArrayList<String> serverNames = new ArrayList<String>();
        serverNames.add("yourhostname1");
        serverNames.add("yourhostname2");
        serverNames.add("yourhostname3");
        serverNames.add("yourhostname4");
        String portNumber = "1521";
        String sid = "ORCLSID";
        String url = "jdbc:oracle:thin:@(DESCRIPTION=(ADDRESS_LIST=(LOAD_BALANCE=ON)(FAILOVER=ON)" ;
        for (String serverName : serverNames) {  
            url += "(ADDRESS=(PROTOCOL=tcp)(HOST="+serverName+")(PORT="+portNumber+"))";
        }
        url += ")(CONNECT_DATA=(SID="+sid+")))";
        String username = "USERNAME";
        String password = "PASSWORD";
        // System.out.println(url); // for debugging, if you want to see the url that was built
        Connection conn = DriverManager.getConnection(url, username, password);
    }
}