@JsonIgnoreProperties(ignoreUnknown = true) // required to skip the "all" attribute in the JSON
@JsonFilter("allFilter") // Specify the filter
public class EODPrice {
    private final BigDecimal close;
    private final BigDecimal high;
    private final BigDecimal low;
    private final BigDecimal open;

    // Builder method, does not include "all"
    @JsonCreator
    public EODPrice(
            @JsonProperty("open") final BigDecimal open,
            @JsonProperty("low") final BigDecimal low,
            @JsonProperty("close") final BigDecimal close,
            @JsonProperty("high") final BigDecimal high) {

        this.open = open;
        this.low = low;
        this.close = close;
        this.high = high;
    }

    // This is not part of the JSON but puts the business logic in the POJO
    @JsonIgnore
    public boolean allFieldsEqual() {
        return open.equals(low) && open.equals(close) && open.equals(high);
    }

    public BigDecimal getAll() {
        if (allFieldsEqual()) {
            return open;
        }
        return BigDecimal.ZERO;
    }

    public BigDecimal getClose() {
        return close;
    }

    public BigDecimal getHigh() {
        return high;
    }

    public BigDecimal getLow() {
        return low;
    }

    public BigDecimal getOpen() {
        return open;
    }
}