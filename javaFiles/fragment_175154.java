List<Uitlening> retrieveData() {
    final String query = "SELECT * FROM uitlening";
    try (Connection connection = DriverManager.getConnection(url, login, password);
         Statement statement = connection.createStatement();
         ResultSet resultSet = statement.executeQuery(query)) {
        return processResultSet(resultSet);
    } catch (SQLException e) {
        throw new RuntimeException(e);
    }
}

List<Uitlening> processResultSet(ResultSet resultSet) throws SQLException {
    List<Uitlening> uitleningen = new ArrayList<>();
    while (resultSet.next()) {
        Uitlening uitlening = new Uitlening();
        uitlening.setNr(resultSet.getInt("nr"));
        uitleningen.add(uitlening);
    }
    return uitleningen;
}