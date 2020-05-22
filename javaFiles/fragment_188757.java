class Tuple<T extends Element<?>> {

    private final T element1;
    private final T element2;

    public Tuple(T element1, T element2) {
        this.element1 = element1;
        this.element2 = element2;
    }

    public T getElement1() {
        return element1;
    }

    public T getElement2() {
        return element2;
    }
}