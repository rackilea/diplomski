Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
ResultSet resultSet = statement.executeQuery("select noorder from orders");
resultSet.afterLast();
while (resultSet.previous()) {
  String productCode = resultSet.getString("col_one");
  String productName = resultSet.getString("col_two");

}
connection.close();