final Set<MetricAttribute> disabled = new HashSet<MetricAttribute>();
disabled.add(MetricAttribute.MAX);

final GraphiteReporter reporter = GraphiteReporter
    .forRegistry(metricRegistry)
    .disabledMetricAttributes(disabled)
    .build(graphite)