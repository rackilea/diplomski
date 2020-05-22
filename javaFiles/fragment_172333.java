import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class JsonApp {

  public static void main(String[] args) throws Exception {
    File jsonFile = new File("./test.json");

    ObjectMapper mapper = new ObjectMapper();
    JsonNode root = mapper.readTree(jsonFile);
    Map<String, JsonNode> map = new JsonFlattener(root).flatten();

    System.out.println("Use key-value pairs:");
    map.forEach(
        (k, v) -> {
          System.out.println(k + " => " + v);
        });

    System.out.println();
    System.out.println("Use pointers:");
    map.forEach(
        (k, v) -> {
          System.out.println(k + " => " + root.at(k));
        });
  }
}

class JsonFlattener {

  private final Map<String, JsonNode> json = new LinkedHashMap<>(64);
  private final JsonNode root;

  JsonFlattener(JsonNode node) {
    this.root = Objects.requireNonNull(node);
  }

  public Map<String, JsonNode> flatten() {
    process(root, "");
    return json;
  }

  private void process(JsonNode node, String prefix) {
    if (node.isObject()) {
      ObjectNode object = (ObjectNode) node;
      object
          .fields()
          .forEachRemaining(
              entry -> {
                  process(entry.getValue(), prefix + "/" + entry.getKey());
              });
    } else if (node.isArray()) {
      ArrayNode array = (ArrayNode) node;
      AtomicInteger counter = new AtomicInteger();
      array
          .elements()
          .forEachRemaining(
              item -> {
                process(item, prefix + "/" + counter.getAndIncrement());
              });
    } else {
      json.put(prefix, node);
    }
  }
}