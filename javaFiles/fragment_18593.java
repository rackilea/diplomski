@JsonPOJOBuilder(withPrefix = "")
public static class MainBuilder {
    private int id;
    @JsonProperty(value="@id")
    public MainBuilder id() {
        this.id = id;
        return this;
    }
}