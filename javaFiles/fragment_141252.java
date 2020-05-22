public class MyBean {
    @Autowired @Qualifier("dataSourceMap")
    private Map<String, DataSource> dataSourceMap;

    @Value("#{jobParameters['datasource.number']}")
    private String dbKey;

    public void useTheDataSource() {
        DataSource ds = dataSourceMap.get(dbKey);

        ...
    }
}