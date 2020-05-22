class MyDelegatingDS extends DelegatingDataSource {
  private final String catalogName;

  public MyDelegatingDS(final String catalogName, final DataSource dataSource) {
    super(dataSource);
    this.catalogName = catalogName;
  }

  @Override
  public Connection getConnection() throws SQLException {
    final Connection cnx = super.getConnection();
    cnx.setCatalog(this.catalogName);
    return cnx;
  }

  // maybe also override the other getConnection();
}

// then use like that: new JdbcTemplate(new MyDelegatingDS("catalogName", dataSource));