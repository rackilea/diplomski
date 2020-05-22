public class A {
    public void myMethod() { ... }
}

public class B extends A {
    public void myMethod() {
        // something
    }

    protected void myMethodA() {
        super.myMethod();
    }
}

public class C extends B {
    public void myMethod() {
        myMethodA();
    }
}