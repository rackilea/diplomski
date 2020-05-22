String sql = "INSERT INTO account (name, balance) VALUES (?, 0)";
try (PreparedStatement stmt = conn.prepareStatement(sql,
        Statement.RETURN_GENERATED_KEYS)) {
    stmt.setString(1, name);
    int updateCount = stmt.executeUpdate(); // 1
    try (ResultSet id = stmt.getGeneratedKeys()) {
        id_user = 0;
        if (id.next()) { // 'if' as just 1 row inserted.
            id_user = id.getInt(1); // 1 key per row.
        }
    }
    System.out.println(id_user);
}