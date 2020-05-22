public class C { 
    public void f() { ... }
    public void g() { ... } 

    public IA getAsIO() {
        return new IA() {
            public void f() {
                C.this.f();
            }
        };
    }

    public IB getAsIB() { 
        // similar
    }
}
public class A {
    public void doSomething(IA anIA) {
        C aC = (C) anIA; // illegal
        aC.g();
    }
}