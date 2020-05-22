public class JsonUtils {
    public interface TextFixer {
        public String fix(String string);
    }

    public static JsonNode walkJsonNode(JsonNode node, TextFixer fixer) {
        if (node.isTextual()) {
            String fixedValue = fixer.fix(node.getTextValue());
            return new TextNode(fixedValue);

        } else {
            if (node.isArray()) {
                ArrayNode array = (ArrayNode)node;
                for (int i = 0; i < array.size(); i++) {
                    JsonNode value = array.get(i);
                    JsonNode fixedValue = walkJsonNode(value, fixer);
                    array.set(i, fixedValue);
                }

            } else if (node.isObject()) {
                ObjectNode object = (ObjectNode)node;
                Iterator<String> ite = object.getFieldNames();
                while (ite.hasNext()) {
                    String fieldName = ite.next();
                    JsonNode value = object.get(fieldName);
                    JsonNode fixedValue = walkJsonNode(value, fixer);
                    object.put(fieldName, fixedValue);
                }
            }

            return node;
        }
    }
}