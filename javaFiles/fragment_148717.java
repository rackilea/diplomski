public String select(String username, String password) throws Exception {
    String sql = "SELECT * FROM user WHERE username = ? AND password = ?";
    PreparedStatement ps = connection.prepareStatement(sql);
    ps.setLong(1, Long.parseLong(username));
    ps.setLong(1, Long.parseLong(password));

    ResultSet result = ps.executeQuery();

    while (result.next() != false) {
        System.out.println("Username or password is incorrect.");
    }
}