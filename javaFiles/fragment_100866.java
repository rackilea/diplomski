try {
    conn = DriverManager.getConnection("jdbc:mysql://" + toServer.getHostname(),
           toServer.getUsername(),
           toServer.getPassword());

    conn.setCatalog("someDifferentDB");

    System.out.println("Connected to the server!");

} catch (SQLException e) {
    System.out.println(e.toString());
}