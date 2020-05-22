public static enum FooBar {
    A("a", "xx"), B("b"), C("c");

    private String[] names;

    FooBar(String... names) {
        this.names = names;
    }

    public String[] getNames() {
        return names;
    }
}