class TrackedEntity {
    private final String id;
    private final String name;

    @JsonCreator
    TrackedEntity(
            @JsonProperty("id") final String id,
            @JsonProperty("name") final String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}