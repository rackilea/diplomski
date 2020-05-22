@Override
public void run(MyConfiguration configuration, Environment environment) {
    LogFilter logFilter = new LogFilter();
    environment.jersey().getResourceConfig().getContainerRequestFilters().add(logFilter);
    environment.jersey().getResourceConfig().getContainerResponseFilters().add(logFilter);
}