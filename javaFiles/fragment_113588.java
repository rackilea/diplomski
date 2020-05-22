public class Money {
    @JacksonXmlProperty(isAttribute = true)
    public final String id;
    public final String description;
    private final String currency;
    private final Double cost;

    @JsonCreator
    public Money(@JsonProperty("id") String id,
                 @JsonProperty("description") String description,
                 @JsonProperty("currency") String currency,
                 @JsonProperty("cost") Double cost) {
        this.id = id;
        this.description = description;
        this.currency = currency;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getCurrency() {
        return currency;
    }

    public Double getCost() {
        return cost;
    }
}