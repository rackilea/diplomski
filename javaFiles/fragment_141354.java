public class Foo {
    static int bar;
}

Foo a = new Foo();
a.bar = 3;

Foo b = new Foo();
Log.d("tag", "value = " + b.bar); // this will print 3