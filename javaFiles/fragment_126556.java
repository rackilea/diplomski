enum Status {

    ACTIVE("Active", 1), IN_ACTIVE("In Active", 2);

    private final String key;
    private final Integer value;

    Status(String key, Integer value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }
    public Integer getValue() {
        return value;
    }
}