@Mock private InfluxDB influxDB;
    @Test
    public void validateMetrics() {
        MetricsCollector metricsCollector = null;
        String influxHost = "http://localhost";
        String credentials = "admin:admin";
        String influxDatabaseName = "testDataBase";

        influxDB = InfluxDBFactory.connect(influxHost, credentials.split(":")[0], credentials.split(":")[1]);

       try {
            String hostName = "test-server-01";
            int statusValue = 1;
            metricsCollector = new MetricsCollector(influxDB);

            BatchPoints metrics = metricsCollector.initBatchPoint(influxDatabaseName); 
            Point point = metricsCollector.setMetric(hostName, "status", statusValue);
            metrics = metricsCollector.addToMetrics(metrics, point);

            Assert.assertTrue(metrics.getPoints().get(0).lineProtocol().contains(hostName));
            Assert.assertTrue(metrics.getPoints().get(0).lineProtocol().contains("status=" + statusValue));
       } finally {
           if (metricsCollector != null) {
                metricsCollector.closeConnection();
            }
       }
    }