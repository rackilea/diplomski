interface MyInterface {
    public void someMethod();
}
class A implements MyInterface {
    public void someMethod() {
        // do something
    }
}
class B extends A {
    public void someMethod() {
        // do something different
    }
}

class C implements MyInterface {
    private final MyIntegerface delegate;
    public C(MyIntegerface delegate) {
        this.delegate = delegate;
    }
    public void someMethod() {
        delegate.someMethod(); 
    }
}