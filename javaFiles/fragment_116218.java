class SubFoo extends Foo
{
    Foo target;

    SubFoo( Foo target ) { this.target = target };

    public void method1() { target.method1(); }

    ...
}