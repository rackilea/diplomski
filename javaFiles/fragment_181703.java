public class SomeClass<T extends Copyable> {


    public T copy(T object) {
        return (T) object.copy();
    }
}

interface Copyable {
    Copyable copy();
}