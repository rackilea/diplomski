import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class XmlParser {
    static class Entity {
        @JsonProperty("id")
        String id;
        @JsonProperty("name")
        String name;
        @JsonProperty("symbol")
        String symbol;
        @JsonProperty("last_updated")
        String lastUpdated;
        @JsonProperty("quote")
        Map<String, Map<String, Integer>> quote;
    }

    static class Data {
        @JsonProperty("data")
        List<Entity> data;
    }

    public static void main(String[] args) throws Exception {
    final String testJson = "{\"data\":[{\"id\":1,\"name\":\"theName\",\"symbol\":\"theSymbol\",\"last_updated\":\"2018-06-02T22:51:28.209Z\",\"quote\":{\"a\":{\"price\":9283.92},\"b\":{\"price\":1}}}]}";

        ObjectMapper mapper = new ObjectMapper();
        Data data = mapper.readValue(testJson, Data.class);
        System.out.println(mapper.writeValueAsString(data));
    }
}