try (Connection connection = DriverManager.getConnection(url, username, password)) {
    // Success.
}
catch (SQLException e) {
    // Fail.
}