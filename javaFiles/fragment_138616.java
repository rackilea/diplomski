public class PersonSerializer extends JsonSerializer<Person> {
    @Override
    public void serialize(Person person, JsonGenerator jgen, SerializerProvider provider) 
        throws IOException, JsonProcessingException {
        jgen.writeStartObject(String.valueOf(i));
        jgen.writeNumberField("id", i);
        jgen.writeStringField("name", person.getName());
        jgen.writeEndObject();
    }
}