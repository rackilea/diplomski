public enum Type {

    STANDARD(""),
    COMPLEX("complex");

    private String value;

    StatusType(String value) {
        this.value = value;
    }

    @JsonValue
    public String getValue() {
        return value;
    }
}