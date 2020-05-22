private UUID getClientID(String username) {
    try {
        //drop the extra quotes in the SQL statement
        String query = "SELECT id FROM client_table WHERE username = ?";
        //added prepared statement
        PreparedStatement stmt = connection.prepareStatement(query);
        stmt.setString(1, username);
        ResultSet rs = stmt.getResultSet();
        //use 1 to access the first result from the result set
        return UUID.fromString(rs.getString(1));
    } catch (Exception e) {
        e.printStackTrace();
    }
    return null;
}