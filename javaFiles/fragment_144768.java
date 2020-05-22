@Component
public class HealthActuator implements HealthIndicator {
    private MetricsEndpoint metricsEndpoint;

    @Autowired
    private void setMetricsEndpoint(MetricsEndpoint metricsEndpoint) {
        this.metricsEndpoint = metricsEndpoint;
    }

    public HealthActuator() {
    }

    @Override
    public Health health() {
        long uptime = (Long) metricsEndpoint.invoke().get("uptime");
        // logic with uptime
        return Health.up().build();
    }
}