interface WrapperThing<T> {
    void add(T item);
    void remove(T item);
}
class ListWrapperThing<T> implements WrapperThing<T> {
    private List<T> list;
    public ListWrapperThing() {
        list = new LinkedList<T>();
    }
    public void add(T item) {
        list.add(item);
    }
    public void remove(T item) {
        list.remove(item);
    }
}
class MyTypeWrapperThing<T> implements WrapperThing<T> {
    private MyType<T> my;
    public ListWrapperThing() {
        my = new MyType<T>();
    }
    public void add(T item) {
        my.add(item);
    }
    public void remove(T item) {
        my.remove(item);
    }
}