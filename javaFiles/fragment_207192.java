public class Foo {

    public class Bar {
         // Non-static innner class
    }

    public static class Baz {
         // Static inner class
    }
}

public class Example {
    public static void main(String[] args) {
        new Foo(); // this is ok
        new Foo.Baz(); // this is ok
        new Foo.Bar(); // does not compile!

        Foo f = new Foo();
        Foo.Bar bar = f.new Bar(); //this works, but don't do this
    }
}