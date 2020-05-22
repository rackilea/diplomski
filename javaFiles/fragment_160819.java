enum TestEnum {
    One, Two, Three,
    Exclamation("!"), Ampersand("&"), Asterisk("*");

    private final String name;

    private TestEnum(String name) {
        this.name = name;
    }

    private TestEnum() {
        name = super.toString();
    }

    @Override public String toString() {
        return name;
    }
}