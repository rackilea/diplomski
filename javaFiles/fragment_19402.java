@Value("${spring.datasource.custom.tomcat.validation-query}")
private String validationQuery;

@Value("${spring.datasource.custom.tomcat.test-on-borrow}")
private boolean onBorrow;

    org.apache.tomcat.jdbc.pool.DataSource ds = new org.apache.tomcat.jdbc.pool.DataSource();
    ds.setValidationQuery(validationQuery);
    ds.setTestOnBorrow(onBorrow);