class Inventory<T> extends ArrayList<T> {
    private final Class<T> elementType;

    private Inventory(Class<T> elementType) {
        elementType = elementType;
    }

    public Class<T> getElementType() {
        return elementType;
    }

    public static <T> Inventory<T> of(Class<T> elementType) {
        return new Inventory<T>(elementType);
    }
}

// later
Inventory<MyType> inv = Inventory.of(MyType.class);