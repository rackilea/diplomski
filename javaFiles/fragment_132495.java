final class Data {

    private final Type type;
    private final List<?> children; // this one is supposed to be:
                                    // * either List<String> if type=EXTRA
                                    // * or List<Node> if type=NODE

    Data(final Type type, final List<?> children) {
        this.type = type;
        this.children = children;
    }

    Type getType() {
        return type;
    }

    List<?> getChildren() {
        return children;
    }

}