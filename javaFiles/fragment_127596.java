interface Foo<T>{
    public T getValue();
    public void setValue(T value);
}

class IntFoo implements Foo<Integer>{...}
class CharFoo implements Foo<Character>{...}
class DoubleFoo implements Foo<Double>{...}

interface Bar{
    Collection<Foo<?>> getAllFoo();
}