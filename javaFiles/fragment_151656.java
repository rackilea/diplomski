String sql = "INSERT INTO tablename (col1, col2, col3) VALUES (val1, val2, val3)";
// ...

preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, val1); // Fail.
preparedStatement.setString(2, val2);
preparedStatement.setString(3, val3);