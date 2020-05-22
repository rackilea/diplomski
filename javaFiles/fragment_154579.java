public class A {
    class B extends A {
    }
    void foo() {
        new B() { }; // DOES NOT COMPILE!!
    }
}