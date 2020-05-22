public final class InstantiateOnNullDeserializer
    extends JsonNodeDeserializer
{
    @Override
    public JsonNode getNullValue()
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.convertValue(new Value(null), JsonNode.class);
        return node;
    }
}