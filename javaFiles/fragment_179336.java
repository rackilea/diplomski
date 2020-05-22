public int GetAIntFromDatabase(String columblName) {
    final String query = "SELECT * FROM stari ORDER BY id DESC LIMIT 1";
    try (final PreparedStatement preparedStatement = this.connnection.prepareStatement(query)) {
        final ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            return resultSet.getInt(columblName);
        }
        return 0;
    } catch (SQLException ex) {
        // Do something better than System.out.println(...)
        return 0;
    } 
    return 0;
}