public class ConnectionUtil{
static final String url = "jdbc:mysql://localhost:3306/";
static final String dbName = "test";
static final String driver = "com.mysql.jdbc.Driver";
static final String userName = "userparatest";
static final String password = "userparatest";
Connection con = null;
    static Connection getConnection() throws Exception {  
if(con == null)
 {       Class.forName(driver).newInstance();
        con = DriverManager.getConnection(url + dbName, userName,password);     
    }
return con;
}

}