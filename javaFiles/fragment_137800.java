public List<Data> list() throws SQLException {
    List<Data> list = new ArrayList<Data>();

    try (
        Connection connection = database.getConnection();
        Statement statement = connection.createStatement("SELECT id, name, value FROM data");
        ResultSet resultSet = statement.executeQuery();
    ) {
        while (resultSet.next()) {
            list.add(map(resultSet));
        }
    }

    return list;
}

private Data map(ResultSet resultSet) throws SQLException {
    Data data = new Data(); 
    data.setId(resultSet.getLong("id"));
    data.setName(resultSet.getString("name"));
    data.setValue(resultSet.getInteger("value"));
    return data;
}