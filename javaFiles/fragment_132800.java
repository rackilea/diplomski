@Bean
@Qualifier("user1DataSource")
public DataSource userOneDataSource() {
    return DataSourceBuilder.create()
            .username("user1")
            .password("pass")
             ...
             .build();
}

@Bean
@Qualifier("user2DataSource")
public DataSource userOneDataSource() {
    return DataSourceBuilder.create()
            .username("user2")
             ...
             .build();
}

@Bean
@Primary
public RoutingDataSource dataSource(Map<String, DataSource> datasources) {
    return new RoutingDataSource().dataSource(datasources);
 }