public User find(String username, String password) throws SQLException {
    User user = null;

    try (
        Connection connection = dataSource.getConnection();
        PreparedStatement statement = connection.prepareStatement("SELECT id, username, email FROM user WHERE username=? AND password=md5(?)");
    ) {
        statement.setString(1, username);
        statement.setString(2, password);

        try (ResultSet resultSet = statement.executeQuery()) {
            if (resultSet.next()) {
                user = new User();
                user.setId(resultSet.getLong("id"));
                user.setUsername(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
            }
        }
    }       

    return user;
}