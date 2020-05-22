public class OrganisationLightSerializer extends JsonSerializer<Organisation> {
@Override
    public void serialize(Organisation organisation, JsonGenerator jsonGenerator, SerializerProvider serializerProvider)
        throws IOException, JsonProcessingException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeStringField("name", organisation.getName());
        jsonGenerator.writeEndObject();
    }
}