class PersonDTO {

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    private Map<String, String> extras = new HashMap<>();

    @JsonAnySetter
    public void setExtras(String name, String value) {
        this.extras.put(name, value);
    }

    // No args constructor
    // Getters
    // Setters
}