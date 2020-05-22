Producer<String, String> producer = new KafkaProducer<>(configs);

// Find the metrics you are interested in
Metric requestTotalMetric = null;
for (Entry<MetricName, ? extends Metric> entry : producer.metrics().entrySet()) {
    if ("request-total".equals(entry.getKey().name())) {
        requestTotalMetric = entry.getValue();
    }
}

for (int i = 0; i < 1000000000; i++) {
    producer.send(new ProducerRecord<String, String>("topic", "record"));
    // Get metric value at desired interval
    if (i % 100000 == 0) {
        System.out.println(i + " : " + requestTotalMetric.metricValue());
    }
}