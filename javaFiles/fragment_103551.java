public static void main(String[] args) throws SQLException {
    Connection c = getConnection();

    // Build the SQL
    StringBuilder sql = new StringBuilder("SELECT id, name FROM sof.users WHERE id IN (");
    Integer[] data = new Integer[2];
    data[0]= 2;
    data[1]= 4;
    for (int i = 0; i < data.length; i++) {
        sql.append("?,");
    }
    // Delete the last comma
    sql.delete(sql.length()-1, sql.length());
    sql.append(")");

    // Assign prepared statement parameters
    PreparedStatement s = c.prepareStatement(sql.toString());
    for (int i = 0; i < data.length; i++) {
        s.setInt(i+1, data[i]);
    }

    // Output the results
    ResultSet rs = s.executeQuery();
    while (rs.next()) {
        System.out.println("id: " + rs.getInt("id") + "; name: " + rs.getString("name") );
    }
}