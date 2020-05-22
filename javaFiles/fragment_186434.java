String sql = "%my query%";
ResultSet rs;
try {
    rs = SQLSelectStatement.executeQuery(sql);
} catch (SQLException sqle) {
    ConnectSQL(); //try to connect again
    rs = SQLSelectStatement.executeQuery(sql);
}