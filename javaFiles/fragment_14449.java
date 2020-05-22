public class MessageAdapter implements JsonSerializer<Message> {

    @Override
    public JsonElement serialize(Message message, Type type, JsonSerializationContext jsc) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("message_id", message.getMessageId());
        jsonObject.addProperty("message", message.getMessage());
        jsonObject.addProperty("user", message.getUsers().getUsername());
        jsonObject.addProperty("date", message.getDate().toString());
        return jsonObject;      
    }
}