import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class JacksonTester {

    public static void main(String[] args) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        List<ObjectTest> myObjects = mapper.readValue(jsonFile(), new TypeReference<List<ObjectTest>>(){});
        System.out.println(myObjects);
    }

    private static File jsonFile() {
        return new File("src/main/resources/test.json");
    }
}