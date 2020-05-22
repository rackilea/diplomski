public void start() {

    Connection conn = null;
    try {
        work(conn = dbPool.getConnection());
    } finally {
        if (conn != null) {
            conn.close();
        }
    }
}