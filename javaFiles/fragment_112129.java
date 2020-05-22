String sql = "INSERT INTO reports (report_id, sql) values (?, ?)";
try (PreparedStatement stmt = conn.prepareStatement(sql)) {
    stmt.setString(1, reportId);
    stmt.setString(2, sqlQ);
    stmt.executeUpdate();
}