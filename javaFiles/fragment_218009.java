class Foo{
    public static Foo obj1 = new Foo();
    public static Foo obj2 = new Foo();
    public static Foo obj3 = new Foo();
}

Foo f = Foo.obj1.obj2.obj3; // will work fine but you will get a warning from the compiler.