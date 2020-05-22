@Override
protected Object determineCurrentLookupKey() {
  String datasource = RoutingContext.getRoutingKey();
  RoutingContext.clearRoutingKey();
  return datasource;
}