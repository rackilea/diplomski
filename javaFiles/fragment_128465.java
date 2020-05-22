@ConfigurationProperties(prefix = "patterns")
public class AppProperties {

    private Map<String, String> passwordPatterns = new HashMap<>();

    public Map<String, String> getPasswordPatterns() {
        return passwordPatterns;
    }
}