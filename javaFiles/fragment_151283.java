String sql = "INSERT INTO tbl (col1, col2, col3) VALUES (?, ?, ?)";
preparedStatement = connection.prepareStatement(sql);
preparedStatement.setString(1, col1);
preparedStatement.setString(2, col2);
preparedStatement.setString(3, col3);
preparedStatement.executeUpdate();