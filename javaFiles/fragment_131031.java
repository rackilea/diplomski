import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.util.RawValue;

public class JsonApp {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();

        ArrayNode nodes = mapper.getNodeFactory().arrayNode();
        nodes.addRawValue(new RawValue("{}"));
        nodes.addRawValue(new RawValue("true"));
        nodes.addRawValue(new RawValue("{\"id\":1}"));

        System.out.println(mapper.writeValueAsString(nodes));
    }
}