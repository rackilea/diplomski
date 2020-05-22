public class YourItem {
    public String key;
    public String item;
}

public class YourItemSerializer extends StdSerializer<YourItem> {
    @Override
    public void serialize(YourItem value, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonGenerationException {
        jgen.writeStartObject();
        jgen.writeStringField("key", value.key);
        if (!"custom_string".equals(value.item))
            jgen.writeStringField("item", value.item);
        jgen.writeEndObject();
    }
}