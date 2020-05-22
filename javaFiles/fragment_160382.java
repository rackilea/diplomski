public void execMethod(String uid) throws SQLException {

    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", "root", "password")) {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT * from users where uid = ?")) {
            stmt.setString(1, uid);
            try (ResultSet res = stmt.executeQuery()) {
                // Process ressult set
            }
        }
    }
}