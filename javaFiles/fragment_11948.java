protected DataSource dataSource() throws Exception {
    // Create XA datasource
    final LrcXADataSource lrcXADataSource = new LrcXADataSource();
    lrcXADataSource.setDriverClassName(getDataSourceProperty().getDriverClassName());
    lrcXADataSource.setUrl(getDataSourceProperty().getUrl());
    lrcXADataSource.setUser(getDataSourceProperty().getUserName());
    lrcXADataSource.setPassword(DataSourceSecureIdentity.decode(getDataSourceProperty().getPassword()));

    // Create a pool of XA datasource
    final PoolingDataSourceBean poolingDataSourceBean = new PoolingDataSourceBean();
    poolingDataSourceBean.setDataSource(lrcXADataSource);
    poolingDataSourceBean.setMaxPoolSize(getDataSourceProperty().getMaxPoolSize());
    poolingDataSourceBean.setMinPoolSize(getDataSourceProperty().getMinPoolSize());
    poolingDataSourceBean.setTestQuery(getDataSourceProperty().getValidationQuery());

    return poolingDataSourceBean;
}