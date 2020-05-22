try {
    System.out.println("Trying to find user in db");
    ResultSet rs = fbot.getStorage().query("select * from database_name where clientDBId = " + clientDatabaseid);
    // do not access the result set here

    if (rs.next()) {
        DatabasedClient databasedClient = new DatabasedClient(clientDatabaseid);
        databasedClient.setUid(rs.getString("uid"));
        databasedClient.setNick(rs.getString("nick"));
        databasedClient.setLastConnect(rs.getLong("lastConnected"));             
        databasedClient.setLastDisconnect(rs.getLong("lastDisconnect"));
        databasedClient.setTimeSpent(rs.getLong("timeSpent"));
        databasedClient.setLongestConnection(rs.getLong("longestConnection"));
        return databasedClient;
    }
} catch (SQLException e) {
     e.printStackTrace();
}