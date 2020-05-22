public Connection getConnection(String inConnectionType) throws TSPException {
    long start = System.nanoTime();

    Connection conn = null;
    try {
        DataSource dataSource = getDataSource(inConnectionType);
        conn = dataSource.getConnection();
    } catch (SQLException e) {
        log.error(e);
        throw new TSPException(e);
    }

    long end = System.nanoTime();
    double duration = (end - start) / 1000000.0;

    log.debug("Duration getting external db connection=" + duration);

    return conn;
}