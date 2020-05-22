String sqlQuery = "SELECT .... FROM ... ORDER BY global_id ASC";
ResultSet rs = runQuery(sqlQuery); // a made-up method to hide the details
final int x = 10;
final int y = 20;
int i = 0;
while (i < x && rs.next()) {
    i++;
}
while (i < y && rs.next()) {
    // retrieve record
    i++;
}