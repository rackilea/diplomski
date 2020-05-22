private static class Prefix<T> {
    final T value;
    final Prefix<T> parent;

    Prefix(Prefix<T> parent, T value) {
        this.parent = parent;
        this.value = value;
    }

    // put the whole prefix into given collection
    <C extends Collection<T>> C addTo(C collection) {
        if (parent != null)
            parent.addTo(collection);
        collection.add(value);
        return collection;
    }
}