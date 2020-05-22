String myConnectionString =
        "jdbc:mysql://localhost:3307/mydb?" +
        "useUnicode=true&characterEncoding=UTF-8";
try (Connection con = DriverManager.getConnection(myConnectionString, "root", "whatever")) {
    try (PreparedStatement ps = con.prepareStatement("INSERT INTO jdbc (`name`) VALUES (?)")) {
        for (int i = 1; i <= 5; i++) {
            ps.setString(1, String.format(
                    "Line %d: Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.", 
                    i));
            ps.addBatch();
        }
        ps.executeBatch();
    }
}