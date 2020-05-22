import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class Main {

    public static void main(String args[]) throws IOException {

        Main main = new Main();
        File file = main.getFile("data.json");
        ObjectMapper mapper = new ObjectMapper();

        JsonNode root = mapper.readTree(file);

        for (JsonNode jsonNode : root) {
            if (jsonNode instanceof ObjectNode) {
                ObjectNode o = (ObjectNode) jsonNode;
                o.remove("Alias");
                o.remove("Telephone");
            }
        }

        System.out.println(root);    
    }

    private File getFile(String fileName) {
        return new File(getClass().getClassLoader().getResource(fileName).getFile());
    }
}