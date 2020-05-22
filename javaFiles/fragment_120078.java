registry.config().meterFilter(new MeterFilter() {
    @Override
    public DistributionStatisticConfig configure(Meter.Id id, DistributionStatisticConfig config) {
        if (id.getName().equals("http.request.duration")) {
            return DistributionStatisticConfig.builder()
                    .sla(Duration.ofMillis(10).toNanos(),
                         Duration.ofMillis(25).toNanos(),
                         Duration.ofMillis(50).toNanos(), 
                         Duration.ofMillis(100).toNanos(),
                         Duration.ofMillis(500).toNanos(),
                         Duration.ofMillis(1000).toNanos(), 
                         Duration.ofMillis(5000).toNanos())
                    .build()
                    .merge(config);
        }
        return config;
    }
});