@Bean
public Gauge uniqueValueUsedGauge(MeterRegistry registry, UniqueIdService service) {
    return Gauge
        .builder("unique-values-used", service::getPercentageUsed)
        .baseUnit("%")
        .description("Percentage of possible unique values that have been used")
        .register(registry);
    }