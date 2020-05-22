class Foo {
    public void Non() {}
    public virtual void Virt() {}
}

class Bar : Foo {
    public new void Non() {}
    public override void Virt() {}
}

class Baz {
    public static Foo GetFoo() {
        return new Bar();
    }
}

var foo = Baz.GetFoo();
foo.Non();  // <- Foo.Non, not Bar.Non
foo.Virt(); // <- Bar.Virt

var bar = (Bar)foo;
bar.Non();  // <- Bar.Non, not Foo.Non
bar.Virt(); // <- Still Bar.Virt