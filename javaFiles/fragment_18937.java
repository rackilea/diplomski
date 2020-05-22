public void executeBatch(List<Entity> entities) throws SQLException { 
    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement(SQL);
    ) {
        for (Entity entity : entities) {
            statement.setObject(1, entity.getSomeProperty());
            // ...

            statement.addBatch();
        }

        statement.executeBatch();
    }
}