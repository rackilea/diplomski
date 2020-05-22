public class ResponseDeserializer
        extends JsonDeserializer<Response<?>>
        implements ContextualDeserializer {

    private JavaType type;

    @SuppressWarnings("unused")
    public ResponseDeserializer() {
    }

    private ResponseDeserializer(JavaType type) {
        this.type = type;
    }

    @Override
    public JsonDeserializer<?> createContextual(
            DeserializationContext context,
            BeanProperty beanProperty
    ) {
        JavaType contextualType = context.getContextualType();

        if(contextualType == null) {
            contextualType = beanProperty.getMember()
                    .getType();
        }

        if (!contextualType.isTypeOrSubTypeOf(Response.class)) {
            throw new IllegalArgumentException("contextualType should be " + Response.class.getName());
        }

        final JavaType payloadType = contextualType.containedType(0);

        return new ResponseDeserializer(payloadType);
    }

    @Override
    public Response<?> deserialize(
            JsonParser jsonParser,
            DeserializationContext context
    ) throws IOException {
        final ObjectCodec codec = jsonParser.getCodec();
        JsonNode rootNode = codec.readTree(jsonParser);

        final ResponseInfo responseInfo = ResponseInfo.of(
                rootNode.get("code").asInt(),
                rootNode.get("description").asText()
        );

        final JsonNode payloadNode = createPayloadNode(rootNode, codec);
        final JsonParser payloadParser = payloadNode.traverse();

        final Object payload = codec.readValue(payloadParser, type);
        return Response.of(responseInfo, payload);
    }

    private JsonNode createPayloadNode(JsonNode rootNode, ObjectCodec codec) {
        final Map<String, JsonNode> remainingNodes = findRemainingNodes(rootNode);

        if(remainingNodes.size() == 1) {
            final JsonNode payloadNode = remainingNodes.get("payload");

            if(payloadNode != null && !payloadNode.isObject()) {
                return payloadNode;
            }
        }

        return buildRemainingNode(remainingNodes, codec);
    }

    private JsonNode buildRemainingNode(Map<String, JsonNode> remainingNodes, ObjectCodec codec) {
        final ObjectNode remainingNode = (ObjectNode) codec.createObjectNode();
        remainingNodes.forEach(remainingNode::set);
        return remainingNode;
    }

    private Map<String, JsonNode> findRemainingNodes(JsonNode rootNode) {
        Map<String, JsonNode> remainingNodes = new HashMap<>();

        rootNode.fields()
                .forEachRemaining(entry -> {
                    final String key = entry.getKey();

                    if(key.equals("code") || key.equals("description")) {
                        return;
                    }

                    remainingNodes.put(key, entry.getValue());
                });

        return remainingNodes;
    }
}