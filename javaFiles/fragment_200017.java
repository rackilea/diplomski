@ConfigurationProperties(prefix="vehicle")
public class VehicleProperties {
    @Value("${battery.critical.limit}")
    private double mCriticalLimit;

    @Value("${battery.default}")
    private double mTotalPower;

    @Value("${battery.critical.warning}")
    private String powerWarning;
}