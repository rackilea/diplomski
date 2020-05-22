public enum TestEnum {

    CONFIG_USER("config.foobar.user", "dude"),
    CONFIG_PASSWORD("config.foobar.password", "forgetIt"),
    MAX_RETRIES("config.foobar.maxRetries", 30),
    CONSUMER_THREADS("config.foobar.threads", 2);

    private final String property;
    private String value;


    TestEnum(final String property, String defaultValue) {
        this.property = property;
        this.value = defaultValue;
    }

    TestEnum(final String property, final int amount) {
        this.property = property;
        this.value = "" + amount;       // <-------
    }

    public String getProperty() {
        return property;
    }

    public String getValue() {
        return value;
    }
}