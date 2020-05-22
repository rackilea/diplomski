public class Whatever {
    public static void main(String[] args) throws Exception {
        // ... do your frame thing

        loadDataBaseDriver();
        BoneCP connectionPool = createConnectionPool();

        try {
            final Connection connection = connectionPool.getConnection();
            ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();

            exec.scheduleAtFixedRate(new Runnable(){
                @Override
                public void run(){
                    System.out.println("Working ... ");

                    // use connection
                }
            }, 0, 1, TimeUnit.SECONDS);
        } catch (SQLException e) {
          // do whatever
        }
    }

    public static BoneCP createConnectionPool() throws SQLException {
        BoneCPConfig config = new BoneCPConfig();
        config.setJdbcUrl("jdbc:mysql://192.0.0.1:3306/database"); // jdbc url specific to your database, eg jdbc:mysql://127.0.0.1/yourdb
        config.setUsername("root"); 
        config.setPassword("");
        connectionPool = new BoneCP(config);
        return connectionPool;
    }

    public static void loadDataBaseDriver() {
        try {
            // load the database driver (make sure this is in your classpath!)
            Class.forName("com.mysql.jdbc.Driver");
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
    }

}