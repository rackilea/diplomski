public List<Entity> list() throws SQLException {
    List<Entity> entities = new ArrayList<Entity>();
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement(SQL_LIST);
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            entities.add(map(resultSet));
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException logOrIgnore) {}
        if (statement != null) try { statement.close(); } catch (SQLException logOrIgnore) {}
        if (connection != null) try { connection.close(); } catch (SQLException logOrIgnore) {}
    }

    return entities;
}