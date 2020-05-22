@Vetoed
public class ConfiguredService {

    private String value;

    protected ConfiguredService() {
    }

    public ConfiguredService(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}