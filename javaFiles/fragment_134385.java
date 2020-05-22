public void Read() {
    Connection conn = null;
    Statement statement = null;
    ResultSet rs = null;

    try {
        connection  = DriverManager.getConnection(EnvManager.getDbUrl());
        statment = connection.createStatement();
        statement.setFetchSize(Integer.MIN_VALUE);

        // Do more stuff, iterate to ResultSet etc...
    } catch (SQLException ex) {
        // Exception handling stuff
        ...
    } finally {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (statment != null) {
            try {
                statment.close();
            } catch (SQLException e) { /* ignored */}
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) { /* ignored */}
        }
    }
}