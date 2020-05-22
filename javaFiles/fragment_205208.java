Connection con = DriverManager.getConnection("jdbc:mysql://...", user, password);
Statement sqlstat = con.prepareStatement(sqlstatement);
ResultSet rsquery = sqlstat.executeQuery();    // DON'T pass anything to executeQuery()
if (rsquery.next()) {
    Date lastestdbrecordsdate = rs.getDate("most_recent_time");
}