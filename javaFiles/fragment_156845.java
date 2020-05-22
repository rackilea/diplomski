private static Connection getRemoteConnection() {
    ProcessStatus stat = new ProcessStatus();
    try {
        Class.forName("com.mysql.jdbc.Driver");
        String dbName = "xxxxDB";
        String userName = "xxxxx";
        String password = "xxxxxx";
        String hostname = "xxxxxxxx";
        String port = "3306";
        String jdbcUrl = "jdbc:mysql://" + hostname + ":" + port + "/" + dbName + "?user=" + userName + "&password=" + password + "&autoReconnect=true&amp;allowMultiQueries=true";
        Connection con = DriverManager.getConnection(jdbcUrl);
        return con;
    }
    catch (ClassNotFoundException e) { stat.error(e.toString());}
    catch (SQLException e) { stat.error(e.toString());}
    return null;
  }