public List<Biler> list() throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<Biler> bilers = new ArrayList<Biler>();

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT id, name, value FROM Biler");
        resultSet = statement.executeQuery();

        while (resultSet.next()) {
            Biler biler = new Biler();
            biler.setId(resultSet.getLong("id"));
            biler.setName(resultSet.getString("name"));
            biler.setValue(resultSet.getInt("value"));
            bilers.add(biler);
        }
    } finally {
        if (resultSet != null) try { resultSet.close(); } catch (SQLException ignore) {}
        if (statement != null) try { statement.close(); } catch (SQLException ignore) {}
        if (connection != null) try { connection.close(); } catch (SQLException ignore) {}
    }

    return bilers;
}