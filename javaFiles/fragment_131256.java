abstract class MixIn {
    @JsonValue(false) // either annotating members
    private String prop;

    @JsonValue(false) // or annotating methods
    abstract String getProp();
}