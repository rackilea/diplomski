class MyClass<T> {
    private final Collection<? extends T> data;
    MyClass(Comparator<T> comparator, Collection<? extends T> data) {
        this.data = data;
    }
    public void processData() {
        // ...
    }
}

class Factory {
    static <T extends Comparable<T>> MyClass<T> create(Collection<? extends T> data) {
        return new MyClass<T>(new Comparator<T>() {
            public int compare(T o1, T o2) {
                return o1.compareTo(o2);
            }
        }, data);
    }
    static <T> MyClass<T> create(Comparator<T> comparator, Collection<? extends T> data) {
        return new MyClass<T>(comparator, data);
    }
}