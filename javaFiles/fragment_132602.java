String sql = "SELECT c.Description FROM __TestChild c ";
sql += " INNER JOIN __TestParent p ON c.FK = p.ID ";
sql += "WHERE p.Status = 'S'";

try (
    Connection conn = DbConnector.getConnection();
    Statement s = conn.createStatement();
    ResultSet rs = s.executeQuery(sql)
) {
    while(rs.next()) {
        Util.printLog("INFO", rs.getString("Description"));
    }
} catch(SQLTimeoutException sqltoex) {
    Util.printLog("SEVERE",sqltoex);
} catch(SQLException sqlex) {
    Util.printLog("SEVERE",sqlex);
}