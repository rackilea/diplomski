import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

final class JacksonReadExample {

    public static void main(String[] args) throws IOException {

        final String json = " [\n" +
                "   {\n" +
                "     \"txId\": \"ffff-001\",\n" +
                "     \"sender\" : \"0xwwwwwww\",\n" +
                "     \"recepient\" : \"0xeferfef\"\n" +
                "   },\n" +
                "   {\n" +
                "     \"txId\": \"ffff-002\",\n" +
                "     \"sender\" : \"0xwwwwwww\",\n" +
                "     \"recepient\" : \"0xeferfef\"\n" +
                "   }\n" +
                "]";

        final ObjectMapper mapper = new ObjectMapper();

        final JsonNode jsonNode = mapper.readTree(json);

        final List<String> ids = StreamSupport.stream(jsonNode.spliterator(), false)
                .map(node -> node.get("txId").textValue())
                .collect(Collectors.toList());

        System.out.println(ids);
    }
}