public class Document extends LinkedHashMap<String, Object> implements Serializable {
}

public class JacksonMapper {
    private ObjectMapper objectMapper;

    public <T> Document asDocument(T object) {
        ObjectMapper objectMapper = getObjectMapper();
        JsonNode node = objectMapper.convertValue(object, JsonNode.class);
        return loadDocument(node);
    }

    protected ObjectMapper getObjectMapper() {
        if (objectMapper == null) {
            objectMapper = new ObjectMapper();
            objectMapper.setVisibility(
                    objectMapper.getSerializationConfig().
                            getDefaultVisibilityChecker().
                            withFieldVisibility(JsonAutoDetect.Visibility.ANY).
                            withGetterVisibility(JsonAutoDetect.Visibility.NONE).
                            withIsGetterVisibility(JsonAutoDetect.Visibility.NONE)
            );
            objectMapper.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
            objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
        }
        return objectMapper;
    }

    private Document loadDocument(JsonNode node) {
        Document document = new Document();
        Iterator<Map.Entry<String, JsonNode>> fields = node.fields();
        while (fields.hasNext()) {
            Map.Entry<String, JsonNode> entry = fields.next();
            String name = entry.getKey();
            JsonNode value = entry.getValue();
            document.put(name, loadObject(value));
        }

        return document;
    }

    private Object loadObject(JsonNode node) {
        if (node == null) return null;
        try {
            switch (node.getNodeType()) {
                case ARRAY:
                    return loadArray(node);
                case BINARY:
                    return node.binaryValue();
                case BOOLEAN:
                    return node.booleanValue();
                case MISSING:
                case NULL:
                    return null;
                case NUMBER:
                    return node.numberValue();
                case OBJECT:
                    return loadDocument(node);
                case POJO:
                    return loadDocument(node);
                case STRING:
                    return node.textValue();
            }
        } catch (IOException e) {
            return null;
        }
        return null;
    }

    private List loadArray(JsonNode array) {
        if (array.isArray()) {
            List list = new ArrayList();
            Iterator iterator = array.elements();
            while (iterator.hasNext()) {
                Object element = iterator.next();
                if (element instanceof JsonNode) {
                    list.add(loadObject((JsonNode) element));
                } else {
                    list.add(element);
                }
            }
            return list;
        }
        return null;
    }
}