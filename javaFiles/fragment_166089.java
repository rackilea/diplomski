public void add(int i, T structure) {
    int size;
    if (structure.getClass().isArray()) {
        size = Array.getLength(structure);
    } else if (structure instanceof Collection) {
        size = ((Collection) structure).size();
    } else {
        throw new IllegalArgumentException("Structure is neither an array nor a collection");
    }
    if (size > limit) {
        return;
    }
    // ...
}