public List<Biler> list() throws SQLException {
    List<Biler> bilers = new ArrayList<Biler>();

    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, name, value FROM Biler");
        ResultSet resultSet = statement.executeQuery();
    ) {
        while (resultSet.next()) {
            Biler biler = new Biler();
            biler.setId(resultSet.getLong("id"));
            biler.setName(resultSet.getString("name"));
            biler.setValue(resultSet.getInt("value"));
            bilers.add(biler);
        }
    }

    return bilers;
}