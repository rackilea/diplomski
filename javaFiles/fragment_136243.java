class Programs {
    private final List<Program> programs;

    @JsonCreator
    Programs(@JsonProperty("programs") final List<Program> programs) {
        this.programs = programs;
    }

    public List<Program> getPrograms() {
        return programs;
    }
}