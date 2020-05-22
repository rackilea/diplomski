public enum ApplicationStatus {
    LIVE("live"),
    MOCKS("mocks");

    private final String status;

    ApplicationStatus(final String status) {
        this.status = status;
    }

    public String value() { return status; }
}