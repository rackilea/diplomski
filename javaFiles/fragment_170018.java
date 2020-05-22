Date now = new Date();

String sql = "INSERT INTO MyTable ( MyDateTime ) VALUES ( ? )";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setTimestamp(1, new Timestamp(now.getTime()));
    stmt.executeUpdate();
}