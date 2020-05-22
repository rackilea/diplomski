public class Parent {
    ...
    public void method1() {
        method2impl();
    }

    public void method2() {
        method2impl();
    }

    // make it private or final.
    public final method2impl() {
        ...
    }
}