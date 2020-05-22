enum NameValuePair {

    WIDTH("width", 5),
    POTATO("potato", 2);

    private final String name;
    private final int value;

    private NameValuePair(final String name, final int value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    static NameValuePair getByName(final String name) {
        for (final NameValuePair nvp : values()) {
            if (nvp.getName().equals(name)) {
                return nvp;
            }
        }
        throw new IllegalArgumentException("Invalid name: " + name);
    }
}