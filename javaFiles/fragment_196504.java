public class Foo {
    public final void bar(IntfA a) {}
    public final void bar(IntfB b) {}
    public final void bar(IntfC c) {}
}

@FunctionalInterface
public interface IntfA {
    void doSomething(Double a);
}

@FunctionalInterface
public interface IntfB {
    void doSomething(Integer a);
}

@FunctionalInterface
public interface IntfC {
    void doSomething(Double a);
}

public class Test {
    public static void main(String[] args)
    {
        Foo foo = new Foo();

        foo.bar(a -> {}); // Ambiguous
        foo.bar((Integer a) -> {}); // Okay, this is IntfB
        foo.bar((Double a) -> {}); // Ambiguous between IntfA and IntfC
        foo.bar((IntfC) a -> {}); // No longer ambiguous since you specified that it's IntfC
        foo.bar((IntfC) (a, b) -> {}); // Method signature does not match IntfC
    }
}