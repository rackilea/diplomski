// Find the metrics you are interested in
Metric requestLatencyAvgMetric = null;
for (Entry<MetricName, ? extends Metric> entry : consumer.metrics().entrySet()) {
    if ("request-latency-avg".equals(entry.getKey().name())) {
        requestLatencyAvgMetric = entry.getValue();
    }
}