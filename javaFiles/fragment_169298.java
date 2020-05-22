import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.util.Map;

public class Test {
    public static void main(String[] args) throws IOException {
        String str = "{\"versions\": {\"ap\": \"Not Set\", \"am\": \"topic-test-publisher-1.0.16\", \"il\": \"topic-test-publisher-1.0.16\", \"row\": \"topic-test-publisher-1.0.49\"}, \"provider\": \"gce\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        Version v = objectMapper.readValue(str, Version.class);

        System.out.println(v.versions.get("am"));
    }

    public static class Version {
        public Map<String, String> versions;

        public String provider;
    }
}