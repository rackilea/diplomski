@JsonTypeInfo(use = JsonTypeInfo.Id.CLASS, include = JsonTypeInfo.As.PROPERTY)
@JsonDeserialize(using = UnmodifiableSetDeserializer.class)
public abstract class UnmodifiableSetMixin {
    @JsonCreator
    public UnmodifiableSetMixin(Set<?> s) {}
}

public class UnmodifiableSetDeserializer extends JsonDeserializer<Set> {

    @Override
    public Set deserialize(JsonParser jp, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        ObjectMapper mapper = (ObjectMapper) jp.getCodec();
        JsonNode node = mapper.readTree(jp);
        Set<Object> resultSet = new HashSet<Object>();
        if (node != null) {
            if (node instanceof ArrayNode) {
                ArrayNode arrayNode = (ArrayNode) node;
                Iterator<JsonNode> nodeIterator = arrayNode.iterator();
                while (nodeIterator.hasNext()) {
                    JsonNode elementNode = nodeIterator.next();
                    resultSet.add(mapper.readValue(elementNode.toString(), Object.class));
                }
            } else {
                resultSet.add(mapper.readValue(node.toString(), Object.class));
            }
        }
        return Collections.unmodifiableSet(resultSet);
    }
}