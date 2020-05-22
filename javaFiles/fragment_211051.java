class Decorator {
    private final MyObject value;

    public Decorator(MyObject value) {
        this.value = value;
    }

    public MyObject getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        // boilerplate junk here
        if (!o instanceof Decorator) return false;
        Decorator other = (Decorator) o;
        return this.value.getObjID() == other.value.getObjID();
    }

    @Override
    public int hashCode() {
        return this.value.getObjID();
    }
}