class Indexed<T> {
    final int index;
    final T value;
    public Indexed(T value, int index) {
        this.index = index;
        this.value = value;
    }
    @Override
    public String toString() {
        return index + ") " + value;
    }
}

Iterable<Integer> naturals = IntStream.iterate(0, i -> i + 1)::iterator;