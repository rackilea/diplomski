public final class RoutingDataSource extends AbstractRoutingDataSource {
    private final ConcurrentHashMap<String, DataSource> dynamicDataSources = new ConcurrentHashMap<>();

    @Override
    protected Object determineCurrentLookupKey() {
        return UserContextHolder.getUserName() + "_datasource";
    }

    @Override
    protected DataSource determineTargetDataSource() {
        String currentLookupKey = this.determineCurrentLookupKey().toString();
        String userName = UserContextHolder.getUserName();
        String password = UserContextHolder.getPassword();

        return this.dynamicDataSources.computeIfAbsent(currentLookupKey, (key) -> DataSourceBuilder.create()
                .driverClassName("your.driver.class")
                .url("jdbc:same:url/here")
                .username(userName)
                .password(password)
                .build());
    }
}