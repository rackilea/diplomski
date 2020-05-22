private static class WrappedDataSource
implements DataSource
{
    private HikariDataSource delegate;

    public WrappedDataSource(HikariDataSource delegate) {
        this.delegate = delegate;
    }

    @Override
    public Connection getConnection() throws SQLException {
        while (true) {
            Connection cxt = delegate.getConnection();
            try (Statement stmt = cxt.createStatement()) {
                try (ResultSet rslt = stmt.executeQuery("select @@innodb_read_only")) {
                    if (rslt.next() && ! rslt.getBoolean(1)) {
                        return cxt;
                    }
                }
            }
            // evict connection so that we won't get it again
            // should also log here
            delegate.evictConnection(cxt);
            try {
                Thread.sleep(1000);
            }
            catch (InterruptedException ignored) {
                // if we're interrupted we just retry
            }
        }
    }

    // all other methods can just delegate to HikariDataSource