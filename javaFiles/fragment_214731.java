class main {
    public static void main(String args[]) {
            A a = new B();
            B b = new B();
            a.foo();
            b.foo();
            a.callMe();
            b.callMe();
    }
}
abstract class A {
    public static void foo() {
        System.out.println("I am superclass");
    }

    public void callMe() {
        foo(); //no late binding here; always calls A.foo()
    }
}

class B extends A {
    public static void foo() {
        System.out.println("I am subclass");
    }
}