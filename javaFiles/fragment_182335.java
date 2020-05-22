public class A {
    private class B {}
    public class C {}
    public C getC() { 
        return new C();
    }
    public B getB() {
        return new B();
    }

}
public class Tryout {
    public static void main(String[] args) {
        A a = new A();
        A.B b = a.getB(); //cannot compile
        A.C c = a.getC(); //compiles perfectly
    }
}