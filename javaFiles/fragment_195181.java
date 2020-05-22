public class Database {
    private static Latte instance = Latte.getInstance();
    private static Config config = new Config();
    private static HikariConfig dbConfig;

    static {

        dbConfig = new HikariConfig();
        dbConfig.setJdbcUrl("jdbc:mysql://localhost:3306/" + config.get("database.database"));
        dbConfig.setUsername(config.get("database.username"));
        dbConfig.setPassword(config.get("database.password"));
        dbConfig.setDriverClassName("com.mysql.jdbc.Driver");
        dbConfig.addDataSourceProperty("cachePrepStmts", "true");
        dbConfig.addDataSourceProperty("prepStmtCacheSize", "250");
        dbConfig.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");
    }

    private static HikariDataSource ds = new HikariDataSource(dbConfig);

    public static <T> T execute(ConnectionCallback<T> callback) {
      try (Connection conn = ds.getConnection()) {
        return callback.doInConnection(conn);
      } catch (SQLException e) {
           throw new IllegalStateException("Error during execution.", e);
      }
    }

    public static interface ConnectionCallback<T> {
        public T doInConnection(Connection conn) throws SQLException;
    }
}