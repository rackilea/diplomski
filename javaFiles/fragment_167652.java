public CachedRowSet getContentsOfCoffeesTable(Connection mycConn)
    throws SQLException {

CachedRowSet crs = null;
ResultSet resultSet = null;
Statement stmt = null;
String sql = "select COF_NAME, SUP_ID, PRICE, SALES, TOTAL from COFFEES";

try {

    stmt = myConn.createStatement();
    resultSet = stmt.executeQuery(sql);

    crs = new CachedRowSetImpl();
    crs.populate(resultSet);

}

catch (Exception e) {

    e.printStackTrace();
}

return crs;
 }