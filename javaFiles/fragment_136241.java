class ProgramStage {
    private final String id;

    @JsonCreator
    ProgramStage(@JsonProperty("id") final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}