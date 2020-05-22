try (
    Connection connection = DatabaseManager.getConnection();
    PreparedStatement stmt = DatabaseManager.prepareStatement(connection, SQL, ps -> ps.setString(1, "foo"));
    ResultSet rs = stmt.executeQuery()
) {
    // rest of code
}