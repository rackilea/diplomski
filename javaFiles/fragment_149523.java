public enum CustomLogLevel {
    ERROR(1),
    DEBUG(2),
    INFO(3),
    WARNING(4),
    IGNORE(5);

    private int value;

    private CustomLogLevel(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}