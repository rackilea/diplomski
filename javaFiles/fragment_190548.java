class Bar<T> {...}

interface Foo<T extends Comparable<?>> {
    Bar<T> doSomething(Bar<T> otherBar);
    ...
}