import org.codehaus.jackson.JsonNode;
import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;

public class Main {

    public static class Me {
        public String key;
    }

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String json = "{\"key\" : \"value\"}";

        // Feature 1
        JsonNode rootNode = mapper.readValue(json, JsonNode.class);
        System.out.println(rootNode.get("key").getTextValue());

        // Feature 2
        Me value = mapper.readValue(json, Me.class);
        System.out.println(value.key);
    }
}