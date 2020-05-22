public final class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return UserContextHolder.getUserName() + "DataSource";
    }
}