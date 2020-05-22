public void executeBatch(List<Entity> entities) throws SQLException { 
    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
    ) {
        int i = 0;

        for (Entity entity : entities) {
            statement.setObject(1, entity.getSomeProperty());
            // ...

            statement.addBatch();
            i++;

            if (i % 1000 == 0 || i == entities.size()) {
                statement.executeBatch(); // Execute every 1000 items.
            }
        }
    }
}