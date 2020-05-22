public void create(Entity entity) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;

    try { 
        connection = database.getConnection();
        statement = connection.prepareStatement(SQL_CREATE);
        statement.setSomeObject(1, entity.getSomeProperty());
        // ...
        statement.executeUpdate();
    } finally {
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }
}