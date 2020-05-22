public class Container<T> {
    T object;
    Container(T a) {
        object = a;
    }

    T getObject() {
        return object;
    }
}