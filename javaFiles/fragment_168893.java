String query = SELECT <column> FROM <table> WHERE id=?;
String sql = query.replaceAll("<column>", column).replaceAll("<table>", table);
PreparedStatement preparedStatement = getConnection().prepareStatement(sql);
preparedStatement.setInt(1, id);
ResultSet resultSet = preparedStatement.executeQuery();
while (resultSet.next()) {
    output = resultSet.getString(column);
}