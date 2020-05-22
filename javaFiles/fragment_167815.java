String sql = "SELECT SUM(SALE) as TOTAL_SALE FROM tbl WHERE [DATE] = ? GROUP BY [DATE]";
java.util.Date date = new SimpleDateFormat("MM/dd/yyyy").parse("8/31/2010");

Connection connection = null;
PreparedStatement statement = null;
ResultSet resultSet = null;
int totalSale = 0;

try {
    connection = database.getConnection();
    statement = connection.prepareStatement(sql);
    statement.setDate(new java.sql.Date(date.getTime());
    resultSet = statement.executeQuery();
    if (resultSet.next()) {
        totalSale = resultSet.getInt("TOTAL_SALE");
    }
} finally {
    close(connection, statement, resultSet);
}