private DataSource createDsManuallyUsingSomeExternalConfigurationSource() {
    DataSource ds = new org.apache.commons.dbcp.BasicDataSource();
    ds.setDriverClassName("org.h2.Driver");
    ds.setUrl(/*New database URL*/);
    ds.setUsername(/*New username*/);
    ds.setPassword(/*New password*/);
    return ds;
}