SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
String lower = "2018-07-23 04:00:00";
String upper = "2018-07-23 04:03:02";
Date lowerdt = formatter.parse(lower);
Date upperdt = formatter.parse(upper);
String sql = "SELECT * FROM yourTable WHERE ts_col BETWEEN ? AND ?;";
Statement statement = conn.createStatement(sql);
statement.setTimestamp(1, new java.sql.Timestamp(lowerdt.getTime()));
statement.setTimestamp(2, new java.sql.Timestamp(upperdt.getTime()));
ResultSet rs = statement.executeQuery();
while (rs.next()) {
    // process result set
}