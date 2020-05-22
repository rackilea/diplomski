@ConfigurationProperties("")
public class CustomProperties {

    private final Map<String, String> namespace = new HashMap<>();

    public Map<String, String> getNamespace() {
        return namespace;
    }

}