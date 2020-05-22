Connection conn=null;
Statement s=null;
try {
    Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
    conn = DriverManager.getConnection("jdbc:odbc:SS");
    s = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
    s.executeUpdate("drop table users");
    s.executeUpdate("CREATE TABLE users ( id AUTOINCREMENT, username varchar(255) , pass varchar(255), PRIMARY KEY(id) ) ");
    s.executeUpdate("insert into users (username, pass) values( 'name1', 'pass1') ");
    s.executeUpdate("insert into users (username, pass) values( 'name2', 'pass2') ");
} catch (SQLException ex) {
    ex.printStackTrace();
} catch (Exception ee) {
    ee.printStackTrace();
} finally {
    try {
        conn.close();
        s.close();
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
}