public class Foo {
    {
        System.out.println("Before Foo()");
    }

    public Foo() {
        System.out.println("Inside Foo()");
    }

    {
        System.out.println("Not After Foo()");
    }
}