Connection connection = null;
PreparedStatement statement = null;
try {
    connection = database.getConnection();
    statement = connection.prepareStatement(SQL);
    for (int i = 0; i < items.size(); i++) {
        Item item = items.get(i);
        statement.setString(1, item.getSomeValue());
        // ...
        statement.addBatch();
        if ((i + 1) % 100 == 0) {
            statement.executeBatch(); // Execute every 100 items.
        }
    }
    statement.executeBatch();
} finally {
    if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
    if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
}