final class DataJsonDeserializer
        implements JsonDeserializer<Data> {

    private static final JsonDeserializer<Data> dataJsonDeserializer = new DataJsonDeserializer();

    private static final java.lang.reflect.Type nodeListType = new TypeToken<List<Node>>() {
    }.getType();

    private static final java.lang.reflect.Type stringListType = new TypeToken<List<String>>() {
    }.getType();

    private DataJsonDeserializer() {
    }

    static JsonDeserializer<Data> getDataJsonDeserializer() {
        return dataJsonDeserializer;
    }

    @Override
    public Data deserialize(final JsonElement jsonElement, final java.lang.reflect.Type type, final JsonDeserializationContext context)
            throws JsonParseException {
        final JsonObject rootJsonObject = jsonElement.getAsJsonObject();
        final Type nodeType = context.deserialize(rootJsonObject.get("type"), Type.class);
        final JsonArray childrenJsonArray = rootJsonObject.get("children").getAsJsonArray();
        final List<?> children;
        switch ( nodeType ) {
        case NODE:
            children = context.deserialize(childrenJsonArray, nodeListType);
            break;
        case EXTRA:
            children = context.deserialize(childrenJsonArray, stringListType);
            break;
        default:
            throw new AssertionError(nodeType);
        }
        return new Data(nodeType, children);
    }

}