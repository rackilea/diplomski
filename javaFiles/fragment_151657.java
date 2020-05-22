String sql = "INSERT INTO tablename (col1, col2, col3) VALUES (?, ?, ?)";
// ...

preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, val1);
preparedStatement.setString(2, val2);
preparedStatement.setString(3, val3);