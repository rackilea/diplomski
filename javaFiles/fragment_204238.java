public interface TestFoo {
    public int Foo (int a);
    public int Foo (int a, int b);
    public int Foo (int a, int b, int c);
}

public interface TestFooTrait extends TestFoo {      
    default public int Foo (int a) {
        return a+1;
    }

    default public int Foo (int a, int b) {
        return b+1;
    }

    default public int Foo (int a, int b, int c) {
        return c+1;
    }
}

class TestFooImpl implements TestFooTrait {
  // I don't have to impelemt anything :)
}