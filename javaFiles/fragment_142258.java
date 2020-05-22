public class CustomerNameJsonSerializer extends JsonSerializer<String> {

    @Override
    public void serialize(String customerName, JsonGenerator jg, SerializerProvider sp) throws IOException {
        jg.writeStartObject();

        jg.writeFieldName("forenames");
        jg.writeString(/* extract your forenames from customerName */);

        jg.writeFieldName("surname");
        jg.writeString(/* extract your surname from customerName */);

        jg.writeEndObject();
    }

}

public class CustomerNameJsonDeserializer extends JsonDeserializer<String> {

    @Override
    public String deserialize(JsonParser jp, DeserializationContext dc) throws IOException {
        TreeNode tree = jp.readValueAsTree();
        TextNode forenames = (TextNode) tree.path("forenames");
        TextNode surname = (TextNode) tree.path("surname");

        return forenames.asText() + ":" + surname.asText();
    }

}

public class CustomerVo {

    @JsonProperty("last4")
    private String emailAddress; 

    @JsonProperty("name")
    @JsonSerialize(using = CustomerNameJsonSerializer.class)
    @JsonDeserialize(using = CustomerNameJsonDeserializer.class)
    private String customerName; 

}