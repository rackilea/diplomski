private Connection conn = null;
private Statement state = null;

public Commands() throws SQLException{
    conn = DbConn.getInstance();
    state = conn.createStatement();
}