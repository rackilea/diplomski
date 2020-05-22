@Configuration
public class MetricsConfig {
  @Bean
  public MeterRegistryCustomizer<MeterRegistry> commonTags() {
    return r -> r.config().commonTags("commonTag", "somePrefix");
  }
}