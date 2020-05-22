public class MoneyBean {
    //...

    @JsonProperty("amountOfMoney")
    @JsonSerialize(using = MoneySerializer.class)
    private BigDecimal amount;

    //getters/setters...
}

public class MoneySerializer extends JsonSerializer<BigDecimal> {
    @Override
    public void serialize(BigDecimal value, JsonGenerator jgen, SerializerProvider provider) throws IOException,
            JsonProcessingException {
        // put your desired money style here
        jgen.writeString(value.setScale(2, BigDecimal.ROUND_HALF_UP).toString());
    }
}