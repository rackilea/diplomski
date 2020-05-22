public static void pingServer(final BasicDataSource source){
    final Thread serverPing = new Thread(new Runnable() {
        @Override
        public void run() {
            Connection conn = null;
            try {
                while(!Thread.currentThread().isInterrupted()){
                    String sql = "/* ping */ SELECT 1";
                    PreparedStatement st = null;
                    conn = source.getConnection();
                    st = conn.prepareStatement(sql);
                    st.executeUpdate(sql);
                    LOGGER.info("Database connection test successful");
                    DatabaseUtilities.closeConnection(conn);
                    TimeUnit.HOURS.sleep(1);
                }
            } catch (SQLException | InterruptedException e) {
                LOGGER.error("Unable to continue pinging database server", e);
                DatabaseUtilities.closeConnection(conn);
            }
            finally{
                DatabaseUtilities.closeConnection(conn);
            }
        }
    });
    serverPing.setDaemon(true);
    serverPing.start();
}