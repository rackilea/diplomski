public abstract class Foo<T extends A> {
    protected abstract T newInstance();
}

public class Bar extends Foo<B> {
    @Override protected final T newInstance() { return new B(); }
}

public class Hesh extends Foo<C> {
    @Override protected final T newInstance() { return new C(); }
}