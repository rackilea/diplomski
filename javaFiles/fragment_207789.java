class OneAuthor extends AbstractMap.SimpleEntry<Integer, String> {
    public OneAuthor(Integer id, String name) {
        super(id, name);
    }

    public String toString() {
        return getValue();
    }
}