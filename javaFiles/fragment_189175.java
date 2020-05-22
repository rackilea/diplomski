final MetricFilter whitelistFilter = new WhitelistMetricFilter(whitelist);
final GraphiteReporter reporter = GraphiteReporter
    .forRegistry(metricRegistry)
    .prefixedWith(getReporterRootTagName())
    .filter(whiltelistFilter)
    .build(graphite);