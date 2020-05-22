public class FooSerializer extends JsonSerializer<Foo> {
    @Override
    public void serialize(Foo value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException {

        gen.writeStartObject();

        Field[] fields = value.getClass().getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            try {
                Foo2 obj = (Foo2) field.get(value);
                gen.writeFieldName(field.getName());
                gen.writeStartObject();
                gen.writeStringField("type", field.getName());
                gen.writeStringField("value", obj.getValue());
                gen.writeStringField("variable", obj.getVariable());
                gen.writeEndObject();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        gen.writeEndObject();
    }
}