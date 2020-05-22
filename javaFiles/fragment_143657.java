public static enum MY_ENUM {

    VALUE_A("aaa %s bbb %s"),
    VALUE_B("bbb %s");

    private final String text;

    MY_ENUM(String text) {
        this.text = text;
    }

    public String toString(Object... o) {
        return String.format(text, o);
    }
}