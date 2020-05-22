interface Interface<T> {
    public void processData();
}

class MyClass<T> implements Interface<T> {
    private final Collection<? extends T> data;
    MyClass(Comparator<T> comparator, Collection<? extends T> data) {
        this.data = data;
    }
    public void processData() {
        // ...
    }
}

class MyCompClass<T extends Comparable<T>> implements Interface<T> {
    private final Collection<? extends T> data;
    MyCompClass(Collection<? extends T> data) {
        this.data = data;
    }
    public void processData() {
        // ...
    }
}

class Factory {
    static <T extends Comparable<T>> Interface<T> create(Collection<? extends T> data) {
        return new MyCompClass<T>(data);
    }
    static <T> Interface<T> create(Comparator<T> comparator, Collection<? extends T> data) {
        return new MyClass<T>(comparator, data);
    }
}