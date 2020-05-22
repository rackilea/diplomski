PreparedStatement ps = dbConnection.prepareStatement(
        "INSERT INTO customers (name, email) " +
        "VALUES (?, ?) " +
        "ON DUPLICATE KEY UPDATE " +
            "name = VALUES(name), " +
            "id = LAST_INSERT_ID(id)");
ps.setString(1, "McMack, Mike");
ps.setString(2, "mike@example.com");
int euReturnValue = ps.executeUpdate();
System.out.printf("executeUpdate returned %d%n", euReturnValue);
Statement s = dbConnection.createStatement();
ResultSet rs = s.executeQuery("SELECT LAST_INSERT_ID() AS n");
rs.next();
int affectedId = rs.getInt(1);
if (euReturnValue == 1) {
    System.out.printf("    => A new row was inserted: id=%d%n", affectedId);
}
else {
    System.out.printf("    => An existing row was updated: id=%d%n", affectedId);
}