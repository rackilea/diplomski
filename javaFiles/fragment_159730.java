class A {
    private A() {  // private to make sure one has to go through factory method
        // ...
    }
    public final void init() {
        // ...
    }
    public static A create() {
        A a = new A();
        a.init();
        return a;
    }
}