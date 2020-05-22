public class Location {
    private boolean needsRecoding;
    private Double longitude;
    private Double latitude;

    // Note the use of JsonNode, as opposed to an explicitly created POJO
    private JsonNode humanAddress;

    public Location() {
        super();
    }

    @JsonCreator
    public Location(
        @JsonProperty("needs_recoding") boolean needsRecoding,
        @JsonProperty("longitude") Double longitude,
        @JsonProperty("latitude") Double latitude,
        @JsonProperty("human_address") JsonNode humanAddress) {

        super();
        this.needsRecoding = needsRecoding;
        this.longitude = longitude;
        this.latitude = latitude;
        this.humanAddress = humanAddress;
    }

    // getters/setters
}