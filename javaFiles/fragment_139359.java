@Component
@ConfigurationProperties(prefix = "prefix")
class MySettings {
    private int intField;

    private String stringField;

    private String customTypeField;

    // getters and setters
}