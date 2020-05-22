public class Foo<T extends SomeInterface> extends Bar<T> {

    public Foo(List<T> someInterfaceList) {
        super(someInterfaceList);
    }

    ...
}