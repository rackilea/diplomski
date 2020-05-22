public class Foo {
    int foo;
}

public static void main(String[] args) {
    Foo f = new Foo();
    f.foo = 3;
    doFoo(f);
    System.out.println(f.foo); // prints 19
}

public static void doFoo(Foo some) {
    some.foo = 19;
}