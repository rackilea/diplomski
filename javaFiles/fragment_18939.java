public void executeBatch(List<Entity> entities) throws SQLException { 
    try (Connection connection = dataSource.getConnection()) {
        connection.setAutoCommit(false);

        try (PreparedStatement statement = connection.prepareStatement(SQL)) {
            // ...

            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
                throw e;
            }
        }
    }
}