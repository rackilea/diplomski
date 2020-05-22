public class MessageDeserializer implements JsonDeserializer<Message> {
    @Override
    public Message deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
        Header header = jdc.deserialize(je.getAsJsonObject().get("header"), Header.class);

        // Get the class representing the body object from the purpose enum
        Class bodyClassType = header.getPurpose().bodyClass;
        Body body = jdc.deserialize(je.getAsJsonObject().get("body"), bodyClassType);

        return new Message(body, header);
    }
}