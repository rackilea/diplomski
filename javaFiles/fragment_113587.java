public class Item {
    @JacksonXmlProperty(isAttribute = true)
    public final String id;
    public final String description;
    public final Double cost;

    @JsonCreator
    public Item(@JsonProperty("id") String id,
                @JsonProperty("description") String description,
                @JsonProperty("cost") Double cost) {
        this.id = id;
        this.description = description;
        this.cost = cost;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public Double getCost() {
        return cost;
    }
}