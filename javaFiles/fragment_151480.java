interface Foo<T> { }

interface Bar<T extends Foo<?>>{
    T doSomething(T o);
}

class IntegerFoo implements Foo<Integer> {}
...

public static void main(String[] args) {
    IntegerFoo integerFoo = new IntegerFoo();

    Bar<IntegerFoo> bar = t -> t;

    Foo<Integer> result = bar.doSomething(integerFoo);
}