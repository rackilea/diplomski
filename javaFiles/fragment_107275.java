DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
String lower = "2018-07-23 04:00:00";
String upper = "2018-07-23 04:03:02";
LocalDateTime lowerdt = LocalDateTime.parse(lower, formatter);
LocalDateTime upperdt = LocalDateTime.parse(upper, formatter);

String sql = "SELECT * FROM yourTable WHERE ts_col BETWEEN ? AND ?;";
Statement statement = conn.createStatement(sql);
statement.setTimestamp(1, Timestamp.valueOf(lowerdt));
statement.setTimestamp(2, Timestamp.valueOf(upperdt));
ResultSet rs = statement.executeQuery();
while (rs.next()) {
    // process result set
}