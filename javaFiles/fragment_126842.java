public class CountryRestrictedAndVatSerializer extends JsonSerializer<CountryRestrictedAndVat> {
    @Override
    public void serialize(CountryRestrictedAndVat value,
                          JsonGenerator gen,
                          SerializerProvider serializers) throws IOException, JsonProcessingException {
        gen.writeStartObject();
        gen.writeObjectField(value.getCountryCode(), value.getRestrictedAndVat());
        gen.writeEndObject();
    }
}