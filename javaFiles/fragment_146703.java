@Configuration(proxyBeanMethods = false)
@AutoConfigureBefore({ CompositeMeterRegistryAutoConfiguration.class, SimpleMetricsExportAutoConfiguration.class })
@AutoConfigureAfter(MetricsAutoConfiguration.class)
@ConditionalOnProperty(prefix = "management.metrics.export.newrelic", name = "enabled", havingValue = "true",
        matchIfMissing = true)
@EnableConfigurationProperties(NewRelicProperties.class)
public class FilteringNewRelicConfiguration {

    private final NewRelicProperties properties;

    public FilteringNewRelicConfiguration(NewRelicProperties properties) {
        this.properties = properties;
    }

    @Bean
    public NewRelicConfig newRelicConfig() {
        return new NewRelicPropertiesConfigAdapter(this.properties);
    }

    @Bean
    public FilteringNewRelicMeterRegistry filteringNewRelicMeterRegistry(NewRelicConfig newRelicConfig, Clock clock) {
        return new FilteringNewRelicMeterRegistry(newRelicConfig, clock)

    }

}