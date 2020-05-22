public class ServiceNameInitializer implements TelemetryInitializer {
    @Override
    public void initialize(Telemetry telemetry) {
        if (telemetry instanceof TraceTelemetry) {
            telemetry.getProperties().put("ServiceName", ServiceNameFromConfigurationOrProcessName);
        }
    }
}