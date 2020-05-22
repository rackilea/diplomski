public class OrgSerializer extends JsonSerializer<Org> {
    @Override
    public void serialize(Org org, JsonGenerator jgen, SerializerProvider provider) 
            throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("institutionCode", org.getInstitutionCode());
        jgen.writeEndObject();
    }
}