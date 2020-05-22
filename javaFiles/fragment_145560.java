package database;

import java.sql.*;


public class DatabaseConnect {

    private Connection con;

    public void connect(String user, String password, String dbUrl) 
           throws ClassNotFoundException, SQLException
{
    Class.forName("oracle.jdbc.driver.OracleDriver");
    con = DriverManager.getConnection(dbUrl, user, password);
}

public void disconnect() throws SQLException
{
    con.close();
}

public void processInsert(String sql) throws SQLException
{
    Statement stmt = con.createStatement();
    stmt.execute(sql);
    stmt.close();
}

public ResultSet processQuery(String sql) throws SQLException
{
    Statement stmt = con.createStatement();
    ResultSet rs = stmt.executeQuery(sql);
    return rs;
}

public PreparedStatement prepareStatement(String sql) throws SQLException{
    PreparedStatement ps = con.prepareStatement(sql);
    return ps;
}

}