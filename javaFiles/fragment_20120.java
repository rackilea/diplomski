class Bar {
    public Bar() {
        f();
    }    
    protected void f() { }
}

public class Foo extends Bar  {
    final String a;
    public Foo() {
        a = "Hello";
    }
    protected void f() {
        System.out.println(a);
    }
    public static void main(String... args) {
        Foo foo = new Foo();
        System.out.println(foo.a);
    }
}