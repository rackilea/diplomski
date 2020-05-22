public class Bar<T extends Bar<T>> extends Foo<T> {

    private final T value;

    public T getValue() { return value; }

    public void method(T param) {
        if (param.getValue().equals(someValue)) {
            doSomething();
        } else {
            doSomethingElse();
        }
    }
}