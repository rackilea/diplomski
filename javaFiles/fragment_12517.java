class MyNode extends Node {

// whatever floats you boat here

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), other);
    }

    @Override
    public boolean equals(Object o) {
    // hashCode() and equals() overrides should always appear together
    }
}