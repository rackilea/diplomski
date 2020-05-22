if (jdbcConnection == null) {
  synchronized (JdbcPersistenceManager.class) {
    if (jdbcConnection == null) {
      jdbcConnection =
          JdbcConnectionManager.getJdbcConnection(jdbcConnectionParameters);
    }
  }
}