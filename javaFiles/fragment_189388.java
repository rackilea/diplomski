Statement stmt = con.createStatement();
String sqlStr ="SELECT max(ID) As LastID FROM GuestBook";
ResultSet rset = stmt.executeQuery(sqlStr);
int id = 0;
if (rset.next()) {
    id = rset.getInt("LastID");
    // OR
    id = rset.getInt(1);
}