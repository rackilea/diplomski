package database;
class Database {
    private String dbUri = "jdbc:mysql://";
    private String dbDriver = "com.mysql.jdbc.Driver";
    private Connection connection;

    public boolean connect(String host, String base, String user, String pass)  {
       try {
            Class.forName(dbDriver);
            String uri = dbUri + host + '/' + base;
            connection = DriverManager.getConnection(uri, user, pass);
            return true;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return false;
            // Could not find the database driver
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
            // Could not connect to the database
        }
    }

    public Connection getConnection() {
        return connection;
    }
}