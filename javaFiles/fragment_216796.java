import org.codehaus.jackson.map.ObjectMapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Example {

    public static void main(String[] args) throws IOException {
        Map<String,String> map = new HashMap<>();
        map.put("key1","value1");
        map.put("key2","value2");

        String mapAsJson = new ObjectMapper().writeValueAsString(map);
        System.out.println(mapAsJson);
    }
}