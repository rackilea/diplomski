public class ColorSerializer extends StdSerializer {

    public ColorSerializer() {
        super(Color.class);
    }

    public ColorSerializer(Class t) {
        super(t);
    }

    public void serialize(Color color, JsonGenerator generator,
      SerializerProvider provider) 
      throws IOException, JsonProcessingException {
        generator.writeStartObject();
        generator.writeFieldName("code");
        generator.writeString(color.getCode());
        generator.writeFieldName("hexCode");
        generator.writeString(color.getHexcode());
        generator.writeFieldName("isAwsome");
        generator.writeNumber(color.isAwsome());
        generator.writeEndObject();
    }
}