public enum TagStatus {
    SUCCESS ("Success"),
    BAD_REQUEST ("Bad Request"),
    DATABASE_PROBLEM ("Database Problem"),
    UNKNOWN_PROBLEM ("Unknown Problem");

    private final String description;

    private TagStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
}