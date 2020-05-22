class SumSet<T extends Addable<T>> implements Set<T> {

    private T element;

    public SumSet(T element) {
        this.element = element;
    }

    public T getSum() {
        return element.add(element.zero());
    }
}