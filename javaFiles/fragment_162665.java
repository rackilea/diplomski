class Foo
{
    private int bar;

    public Foo(int bar)
    {
        // the "this" keyword allows you to specify that
        // you mean "this type" and reference the members
        // of this type - in this instance it is allowing
        // you to disambiguate between the private member
        // "bar" and the parameter "bar" passed into the
        // constructor
        this.bar = bar;
    }
}