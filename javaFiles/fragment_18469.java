public List<User> search(String username) throws SQLException {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;
    List<User> users = new ArrayList<User>();

    try {
        connection = database.getConnection();
        statement = connection.prepareStatement("SELECT id, username, age, email FROM user WHERE username LIKE ?");
        statement.setString(1, "%" + username + "%");
        resultSet = statement.executeQuery();
        while (resultSet.next()) {
            users.add(mapUser(resultSet));
        }
    } finally {
        close(connection, statement, resultSet);
    }

    return users;
}