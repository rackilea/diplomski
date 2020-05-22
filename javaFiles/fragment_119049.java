String sql = "INSERT INTO tbl (col) VALUES (?)";
preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
preparedStatement.setString(1, col);
preparedStatement.executeUpdate();
generatedKeys = preparedStatement.getGeneratedKeys();
if (generatedKeys.next()) {
    long id = generatedKeys.getLong(1);
} else {
    // Throw exception?
}