@ConfigurationProperties(prefix="influxdb")
@Component
public class InfluxDBProperties {

    private String url = "default-url";
    private String dbName = "default-dbname";
    private String username = "default-user";
    private String password = "default-pwd";
    // Other properties of your liking;
    // getters & setters
}