public int GetAIntFromDatabase(String columblName) {
    final String query = "SELECT * FROM stari ORDER BY id DESC LIMIT 1";
    try (final PreparedStatement preparedStatement = this.connnection.prepareStatement(query);
         final ResultSet resultSet = preparedStatement.executeQuery()
    ) {
    ...
}