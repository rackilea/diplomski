@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "CBNOT_CHARGEBACK_AMOUNT"
})
public class TestMonetaryAmountJsonSerialization {
    @JsonProperty("CBNOT_CHARGEBACK_AMOUNT")
    @NotNull
    private final MonetaryAmount chargebackAmount = Monetary.getDefaultAmountFactory().setCurrency("USD").setNumber(12.50).create();

    private static final ObjectMapper mapper = new ObjectMapper();
    static {
        SimpleModule monetaryModule = new SimpleModule();
        monetaryModule.addSerializer(MonetaryAmount.class, new MonetaryAmountSerializer());
        mapper.registerModule(monetaryModule);
    }

    @Test
    public void testThis() throws JsonProcessingException {
        String json = mapper.writeValueAsString(this);
        System.out.println(json);
        Assert.assertEquals("{\"CBNOT_CHARGEBACK_AMOUNT\":\"$12.50\"}", json);
    }

    public static class MonetaryAmountSerializer extends JsonSerializer<MonetaryAmount> {
        public void serialize(MonetaryAmount monetaryAmount,
                              JsonGenerator jsonGenerator,
                              SerializerProvider serializerProvider) throws IOException {
            StringBuilder sb = new StringBuilder();
            MonetaryAmountDecimalFormatBuilder
                    .of("¤#,##0.00").withCurrencyUnit(monetaryAmount.getCurrency()).build()
                    .print(sb, monetaryAmount);
            jsonGenerator.writeString(sb.toString());
        }
    }
}