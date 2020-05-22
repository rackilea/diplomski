@Bean
public DistributionSummary summary(MeterRegistry registry) {
    return DistributionSummary
        .builder("unique-value-attempts")
        .sla(1, 5, 10)
        .publishPercentileHistogram()
        .register(registry);
}