@Bean
@Primary
public DataSource dataSource() {
    return DataSourceBuilder
        .create()
        .username("")
        .password("")
        .url("")
        .driverClassName("")
        .build();
}