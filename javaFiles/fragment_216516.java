class Item {
    private String title;

    @JsonProperty("date")
    private Date createdAt;

    // How to map this?
    @JsonUnwrapped
    private Author author;
}