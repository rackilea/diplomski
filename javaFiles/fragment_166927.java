private static class TObjectDeserializer extends JsonDeserializer<TObject> {
    @Override
    public TObject deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
        JsonNode tree = p.readValueAsTree();
        tree.get("chat");
        TObject resultValue = null;
        if(tree.has("chat")){
            resultValue = p.getCodec().treeToValue(tree.get("chat"), Chat.class);
        }else if(tree.has("message")){
            resultValue = p.getCodec().treeToValue(tree.get("message"),Message.class);
        } else if(tree.has("message_entity")){
            resultValue = p.getCodec().treeToValue(tree.get("message_entity"),MessageEntity.class);
        }
        if(resultValue!= null)
            resultValue.setUpdateId(tree.get("update_id").asInt());
        return resultValue;
    }
}

private static class TObjectSerializer extends JsonSerializer<TObject> {
    private static ObjectMapper mapper = new ObjectMapper();
    @Override
    public void serialize(TObject value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartObject();

        gen.writeNumberField("update_id", value.getUpdateId());
        String key = "";

        if(value instanceof Chat){
            key = "chat";
        }else if(value instanceof Message){
            key =  "message";
        } else if(value instanceof MessageEntity){
            key = "message_entity";
        }
        gen.writeFieldName(key);
        gen.writeRawValue(mapper.writeValueAsString(value));

        gen.writeEndObject();
    }
}