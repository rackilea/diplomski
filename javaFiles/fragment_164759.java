import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonRootName;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        String json = "{...}";
        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(DeserializationFeature.UNWRAP_ROOT_VALUE);

        ContainerStatus cs = mapper.readValue(json, ContainerStatus.class);
        System.out.println(cs.getState());
    }
}

@JsonRootName("containerStatuses")
class ContainerStatus {

    @JsonProperty("name")
    private String name;
    @JsonProperty("state")
    private JsonNode state;
    @JsonProperty("lastState")
    private JsonNode lastState;
    @JsonProperty("ready")
    private Boolean ready;
    @JsonProperty("restartCount")
    private Integer restartCount;
    @JsonProperty("image")
    private String image;
    @JsonProperty("imageID")
    private String imageID;
    @JsonProperty("containerID")
    private String containerID;

    // getters, setters, toString
}