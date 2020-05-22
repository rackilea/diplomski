if (dataSource instanceof org.apache.tomcat.jdbc.pool.DataSource) {
    org.apache.tomcat.jdbc.pool.DataSource tcDataSource = (org.apache.tomcat.jdbc.pool.DataSource)dataSource;
    logger.info(tcDataSource.getUrl());
    logger.info(tcDataSource.getUsername());
    ...
}