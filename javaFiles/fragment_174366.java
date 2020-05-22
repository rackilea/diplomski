public class MoneySerializer extends JsonSerializer<Money> {

    @Override
    public void serialize(Money money, JsonGenerator jgen, SerializerProvider provider) throws IOException, JsonProcessingException {
        jgen.writeStartObject();
        jgen.writeStringField("val", money.getAmount().toString());
        jgen.writeStringField("curr", money.getCurrencyUnit().getCurrencyCode());
        jgen.writeEndObject();
    }

}