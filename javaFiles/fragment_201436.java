class A {
    public void demo() { }
}

class B extends A {
    public void demo() { }
}

public class Test {
    public static void main(String[] args) {
        A a = new B();
        a.demo();   // B class method will be invoked.

        A obj = new A();
        obj.demo();  // A class method will be invoked.
    }
}