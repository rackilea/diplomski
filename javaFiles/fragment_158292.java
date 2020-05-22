public List<Entity> list() throws SQLException {
    List<Entity> entities = new ArrayList<Entity>();

    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_LIST);
        ResultSet resultSet = statement.executeQuery();
    ) {
        while (resultSet.next()) {
            entities.add(map(resultSet));
        }
    }

    return entities;
}