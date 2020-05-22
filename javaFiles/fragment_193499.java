class User {

    private final Map<String, Object> details= new HashMap<>);

    @NotBlank
    private String name;
    private String city;
    private String state;

    @JsonAnySetter
    public void addDetail(String key, Object value) {
      this.details.add(key, value);
    }

    public Map<String, Object> getDetails() { return this.details; }
}