public abstract class MyBaseClass<T extends Foo> {
    public abstract T createObject();
}

public class MyDerivcedClass extends MyBaseClass<FooBar> {
    public FooBar createObject() {
        return new FooBar();
    }
}