public class Money {
    private final String currency;
    private final Double cost;

    @JsonCreator
    public Money(@JsonProperty("currency") String currency,
                 @JsonProperty("cost") Double cost) {
        this.currency = currency;
        this.cost = cost;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getCost() {
        return cost;
    }
}