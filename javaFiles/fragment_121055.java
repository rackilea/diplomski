public class MessageSerializer implements JsonSerializer<Message> {
    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsc) {
        if(message == null) {
            return null;
        }

        JsonObject messageObj = new JsonObject();

        // Get the class representing the body object from the purpose enum
        Class bodyClassType = message.getPurpose().bodyClass;
        messageObj.add("body", jsc.serialize(message.getBody(), bodyClassType));

        messageObj.add("header", jsc.serialize(message.getHeader(), Header.class));

        return messageObj;
    }
}