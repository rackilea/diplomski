package taher.connection;
import com.sun.rowset.CachedRowSetImpl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.rowset.CachedRowSet;
import org.apache.commons.dbcp.BasicDataSource;

/**
 *
 * @author taher_JAVAHUNTER
 */

public class DataTransaction {

private final static String username = "test";
private final static String password = "test";
private final static String url = "jdbc:mysql://127.0.0.1:3309/test";
public Connection connection = null;
public Statement statement = null;
ResultSet rs = null;
public static int connectionCount = 0;

public DataTransaction(boolean setCon) {
    try {
        setConnection();
    } catch (Exception e) {
        System.out.println("Error in Connection:" + e.toString());
    }
}
public static BasicDataSource dataSource;

public void setConnection() throws SQLException {
    try {
        if (dataSource == null) {
            dataSource = new BasicDataSource();
            String driver = "com.mysql.jdbc.Driver";
            try {
                dataSource.setDriverClassName(driver);
                dataSource.setUrl(url);
                dataSource.setUsername(username);
                dataSource.setPassword(password);
                dataSource.setMaxActive(100);
                dataSource.setMaxWait(10000);
                dataSource.setMaxIdle(10);
                if (connection == null || connection.isClosed()) {
                    System.out.println(" requeition CONNECTION WITH FIRST SERVER.");
                    connection = dataSource.getConnection();
                    connectionCount++;
                }
            } catch (SQLException e) {
                System.out.println("***Connection Requisition*** Could not connect to the database msg :" + e.getMessage());
            }
        } else {
            System.out.println("NumActive : "+dataSource.getNumActive());
            System.out.println("NumIdle : "+dataSource.getNumIdle());
            System.out.println("NumTestsPerEvictionRun : "+dataSource.getNumTestsPerEvictionRun());
            if (connection == null || connection.isClosed()) {
                connection = dataSource.getConnection();
                connectionCount++;
            }
        }
    } catch (Exception e) {
        System.out.println("open connection exception" + e);
    }
}

public CachedRowSet viewQuery(String query) throws SQLException, Exception {
    //query = query;
    CachedRowSetImpl crs = new CachedRowSetImpl();
    CachedRowSet crs2 = null;

    try {
        if (connection.isClosed()) {
            setConnection();
        }
    System.out.println("Connection count 1 : " + connectionCount);

        statement = connection.createStatement();
        rs = statement.executeQuery(query);

        crs.populate(rs);
        crs2 = crs.createCopy();
        closeConnection();
        System.out.println("Connection count 2 : " + connectionCount);

    } catch (Exception e) {
        e.printStackTrace();
    }

    return crs2;
}

public void closeConnection() throws SQLException {
    try {
        if (statement != null) {
            statement.close();
        } else {
        }
        if (connection != null) {
            connection.close();                
        }
    } catch (Exception e) {
    }


}

public static void main(String[] args) throws SQLException, Exception {
    DataTransaction dt = new DataTransaction(true);
    for (int i = 0; i < 10; i++) {
        ResultSet rs = dt.viewQuery("select * from tbl_test");
        //ResultSet rs = dt.viewQuery("select * from tbl_test",0);
        System.out.println("Connection closed : " + dt.connection.isClosed());
        while (rs.next()) {
            System.out.println("testId : " + rs.getString(1));
            System.out.println("testName : " + rs.getString(2));
        }
    }

}
}