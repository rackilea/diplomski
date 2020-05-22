public static class Item {

    private final IntegerProperty index = new SimpleIntegerProperty();

    @Override
    public String toString() {
        return Integer.toString(index.get());
    }

}