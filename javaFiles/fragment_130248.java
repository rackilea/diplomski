public class YourAdapter implements JsonDeserializer<Order>, JsonSerializer<Order> {
    @Override
    public Orderde serialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
    // your logic
    }

    @Override
    public JsonElement serialize(Ordersrc, Type typeOfSrc, JsonSerializationContext context) {
        // your logic
    }
}