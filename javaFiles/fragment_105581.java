public class ByReference {

    static class Foo {

        public int i = 0;
    }

    static void changeFoo(Foo fooParam) {
        fooParam.i = 1;
    }

    public static void main(String args[]) {
        Foo foo = new Foo();
        System.out.println(foo.i); // prints 0
        changeFoo(foo); // pass foo to method by reference
        System.out.println(foo.i); // prints 1 -- change persist
    }
}