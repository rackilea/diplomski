import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        File jsonFile = new File("./resource/test.json").getAbsoluteFile();

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(jsonFile);
        ArrayNode tags = (ArrayNode) root.get("tags");
        Iterator<JsonNode> elements = tags.elements();
        while (elements.hasNext()) {
            JsonNode item = elements.next();
            ArrayNode data = (ArrayNode) item.get("data");
            JsonNode v = data.get(0).get("v");
            if (v.isNull()) {
                elements.remove();
            }
        }

        System.out.println(root);
    }
}