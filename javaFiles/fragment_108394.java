interface A {
}

interface B extends A {
    public void def();
}

abstract class C {
    protected abstract <T extends A> void abc(T xyz);
}

class D extends C {
    @Override
    protected void abc(B xyz) {
        xyz.def();
    }

    public static void main(String[] args) {
        D d = new D();
        d.abc(new B(){}); // Invokes def() on a B, OK
        C c = (C) d;      // Cast to a C, OK
        c.abc(new A(){}); // C#abc() applies to an A, but tries to invoke
                          // a's def(), which it lacks
    }
}