public class Invoice {
    private final String some;
    private final String some_other;
    @JsonUnwrapped
    private final Money money;
    private final List<Item> breakdown;

    @JsonCreator
    public Invoice(@JsonProperty("some") String some,
                   @JsonProperty("some_other") String some_other,
                   @JsonProperty("money") Money money,
                   @JacksonXmlProperty(localName = "item") List<Item> breakdown) {
        this.some = some;
        this.some_other = some_other;
        this.money = money;
        this.breakdown = breakdown;
    }

    public String getSome() {
        return some;
    }

    public String getSome_other() {
        return some_other;
    }

    public Money getMoney() {
        return money;
    }

    public List<Item> getBreakdown() {
        return breakdown;
    }
}