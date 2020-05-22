public class A {
    public void foo() {
        // Whatever
    }
}

public class B extends A {
    // ???
}

...
B b = new B();
b.foo(); // I don't want this to work, because it's a B!