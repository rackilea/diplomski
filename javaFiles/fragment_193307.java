import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class Test {

    public static void main(String[] args) {
        String json = "{\"name\":\n" +
                "    [\n" +
                "        {\n" +
                "            \"field1\":\"value1\",\n" +
                "            \"field2\":\"value2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"field1\":\"value1\",\n" +
                "            \"field2\":\"value2\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"field1\":\"value1\",\n" +
                "            \"field2\":\"value2\"\n" +
                "        }\n" +
                "    ]\n" +
                "}";

        ObjectMapper mapper = new ObjectMapper();

        try {
            AnyJsonObject any = mapper.readValue(json, AnyJsonObject.class);
            System.out.println(any);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}