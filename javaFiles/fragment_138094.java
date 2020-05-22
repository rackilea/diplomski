public class ItemSerializer extends StdSerializer<Item> {
    // ...

    @Override
    public void serialize(Item value, JsonGenerator jgen, SerializerProvider provider) {
        // Write the Item data into the JsonGenerator
    }
}