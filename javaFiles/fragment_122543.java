public List<Entity> list() throws SQLException {
    List<Entity> entities = new ArrayList<Entity>();

    try (
        Connection connection = Database.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, foo, bar FROM entity");
        ResultSet resultSet = statement.executeQuery();
    ) {
        while (resultSet.next()) {
            Entity entity = new Entity();
            entity.setId(resultSet.getLong("id"));
            entity.setFoo(resultSet.getString("foo"));
            entity.setBar(resultSet.getString("bar"));
            entities.add(entity);
        }
    }

    return entities;
}