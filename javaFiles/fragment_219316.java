public class ExampleDeserializer extends StdDeserializer<Example> {

    private static final String TYPE_A = "A";
    private static final String TYPE_B = "B";

    public ExampleDeserializer() {
        super(Example.class);
    }

    @Override
    public Example deserialize(JsonParser p, DeserializationContext ctxt) 
                   throws IOException, JsonProcessingException {

        ObjectMapper mapper = (ObjectMapper) p.getCodec();  
        JsonNode tree = mapper.readTree(p);  

        Example example = new Example();

        JsonNode typeNode = tree.get("type");
        if (typeNode == null || typeNode.asText().isEmpty()) {
            throw ctxt.mappingException("\"type\" is required");
        }
        example.setType(typeNode.asText());

        switch (typeNode.asText()) {

        case TYPE_A:
            ArrayNode listANode = (ArrayNode) tree.get("ListA");
            if (listANode == null || listANode.size() == 0) {
                throw ctxt.mappingException(
                           "\"ListA\" is required when \"type\" is \"" + TYPE_A + "\"");
            }
            example.setListA(createList(listANode));
            break;

        case TYPE_B:
            ArrayNode listBNode = (ArrayNode) tree.get("ListB");
            if (listBNode == null || listBNode.size() == 0) {
                throw ctxt.mappingException(
                           "\"ListB\" is required when \"type\" is \"" + TYPE_B + "\"");
            }
            example.setListB(createList(listBNode));
            break;

        default:
            throw ctxt.mappingException(
                       "\"type\" must be \"" + TYPE_A + "\" or \"" + TYPE_B + "\"");
        }


        return example;
    }

    private List<Integer> createList(ArrayNode arrayNode) {
        List<Integer> list = new ArrayList<Integer>();
        for (JsonNode node : arrayNode) {
            list.add(node.asInt());
        }
        return list;
    }
}