import java.util.Map;

import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonProperty;

public class Config {

    private final Map<String, Map<Integer, ConfigValues>> config;


    @JsonCreator
    public Config(@JsonProperty("config") Map<String, Map<Integer, ConfigValues>> config) {
        this.config = config;
    }

    public Map<String, Map<Integer, ConfigValues>> getConfig() {
        return config;
    }
}