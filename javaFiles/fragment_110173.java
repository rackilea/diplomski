public abstract class Foo<T extends A> {
    private final Class<T> type;
    protected Foo(Class<T> type) {
        this.type = Objects.requireNonNull(type);
    }
    private T newInstance() {
        return type.newInstance();
    }
}

public class Bar extends Foo<B> {
    public Bar() {
        super(B.class);
    }
}

public class Hesh extends Foo<C> {
    public Hesh() {
        super(C.class);
    }
}