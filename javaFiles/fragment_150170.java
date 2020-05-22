public void save(List<Entity> entities) throws SQLException {
    try (
        Connection connection = database.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL_INSERT);
    ) {
        int i = 0;

        for (Entity entity : entities) {
            statement.setString(1, entity.getSomeProperty());
            // ...

            statement.addBatch();
            i++;

            if (i % 1000 == 0 || i == entities.size()) {
                statement.executeBatch(); // Execute every 1000 items.
            }
        }
    }
}