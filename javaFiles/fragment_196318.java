public static final class Obj {
    private String property;

    public Obj(String property) {
        this.property = property;
    }

    public String getProperty() {
        return property;
    }

    public Obj modify(String newProperty) {
        return new Obj(property + newProperty);
    }
}