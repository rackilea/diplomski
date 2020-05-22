public class Address {
    private String address;
    private String city;
    private String state;
    private String zip;

    // Constructors, getters/setters
}

public class Location {
    private boolean needsRecoding;
    private Double longitude;
    private Double latitude;
    private Address humanAddress;

    public Location() {
        super();
    }

    @JsonCreator
    public Location(
        @JsonProperty("needs_recoding") boolean needsRecoding,
        @JsonProperty("longitude") Double longitude,
        @JsonProperty("latitude") Double latitude,
        @JsonProperty("human_address") Address humanAddress) {

        super();
        this.needsRecoding = needsRecoding;
        this.longitude = longitude;
        this.latitude = latitude;
        this.humanAddress = humanAddress;
    }

    // getters/setters
}