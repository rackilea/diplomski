final class EmployeeId {
    @JsonProperty("id")
    private final long value;

    @JsonCreator
    public EmployeeId(@JsonProperty("whatever") long value) {
        this.value = value;
    }
}