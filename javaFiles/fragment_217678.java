public static class IosNotificationMessageSerializer extends JsonSerializer<IosNotificationMessage>
{
    @Override
    public void serialize(IosNotificationMessage msg, JsonGenerator gen, SerializerProvider serializers)
            throws IOException, JsonProcessingException
    {
        gen.writeStartObject();
        // serialize IosApsMessage
        gen.writeObjectField("aps", msg.getAps());
        // serialize map entries sequentially, thus skipping map name
        for (Map.Entry<String, Object> customContentEntry : msg.getCustomContent().entrySet()) {
            gen.writeObjectField(customContentEntry.getKey(), customContentEntry.getValue());
        }
        gen.writeEndObject();
    }
}