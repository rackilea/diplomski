@DependsOn({"masterDataSource", "slaveDataSource"})
@Bean(name = "dynamicDataSource")
public DataSource dataSource(@Autowired @Qualifier("masterDataSource") DataSource masterDataSource, @Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource) {
    DynamicDataSource dynamicDataSource = new DynamicDataSource();
    Map<Object, Object> dataSourceMap = new HashMap<>();
    dataSourceMap.put("masterDataSource", masterDataSource);
    dataSourceMap.put("slaveDataSource", slaveDataSource);
    dynamicDataSource.setTargetDataSources(dataSourceMap);
    dynamicDataSource.setDefaultTargetDataSource(masterDataSource);
    return dynamicDataSource;
}