public class DBClass {
private  Connection con;
final   String driverClass = "com.mysql.jdbc.Driver";
final  String url = "jdbc:mysql://localhost:3306/xxxx";      
final  String username = "root";
final  String password = "";        
private static class db_helper
{
    private static final DBClass INSTANCE = new DBClass();
}
public static DBClass getInstance(){

    return db_helper.INSTANCE;
}


public  void makeCon() {
    try {
        Class.forName(driverClass);

        con = DriverManager.getConnection(url, username, password);
        System.out.println("connection established");
    } catch (ClassNotFoundException ex) {
        ex.printStackTrace();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}

public   Connection getCon() throws SQLException {
    if(con==null)
    {
        con = DriverManager.getConnection(url, username, password);
    }
    return con;
}

public void closeCon() {
    try {
        con.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}