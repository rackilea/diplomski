@Bean
@Profile("production")
    public DataSource prodDataSource() {
        ...
        return dataSource;
    }

@Bean
@Profile("development")
    public DataSource devDataSource() {
        ...
        return dataSource;
    }