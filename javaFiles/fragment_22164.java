import dir.barpackage.Bar;

Class Foo
{
    private int x;

    public Foo()
    {
        //Construct an Instance of the Foo object
    }

    public void doSomethingWithBar(Bar bar)
    {
        Foo.x = bar.getSomeBarPropertyValue();
    }
}