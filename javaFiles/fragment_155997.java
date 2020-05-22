enum TShirtSize {    
    SMALL(0, "Small (S)"),
    MEDIUM(1, "Medium (M)"),
    LARGE(2, "Large (L)"),
    XL(3, "X-Large (XL)"),
    XXL(4, "XX-Large (XXL)");

    private final int order;

    private final String identifier;

    TShirtSize(int order, String identifier) {
        this.order = order;
        this.identifier = identifier;
     }

    public static TShirtSize valueOfId(String id) {
            // cache use of values() in an immutable map/set
        return Stream.of(values()).filter(size -> size.identifier.equals(id)).findAny().orElseThrow(IllegalArgumentException::new);
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getOrder() {
        return order;
    }
}