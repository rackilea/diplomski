public class PersonSerializer extends JsonSerializer<Person> {
    @Override
    public void serialize(Person person, JsonGenerator jgen, SerializerProvider provider) 
        throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeFieldName(person.getType());
        jgen.writeStartObject();
        jgen.writeFieldName("name", person.getName());
        jgen.writeFieldName("surname", person.getSurname());
        jgen.writeEndObject();
        jgen.writeEndObject();
    }
}