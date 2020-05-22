public ResultSet retrieveSQLQuery(String sqlQuery) {
    Connection conn = DriverManager.getConnection(dbUrl, user, password);
    try (conn; ResultSet rs = conn.createStatement().executeQuery(sqlQuery)) {
        MyResult result = ...; // parse rs here
        return myResult;               
    } catch (SQLException e) {
        // handle error
    }                    
}