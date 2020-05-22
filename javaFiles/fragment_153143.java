public class MyLibrary
        extends Library
{
    public MyLibrary()
    {
        super("http://example.org/my-project", "my");
    }

    @Override
    protected Function[] functions()
    {
        return new Function[] {
            new MyFunction(this)
        };
    }

}

public class MyFunction
        extends Function
{
    public MyFunction(Library lib)
    {
        super(lib);
    }

    @Override
    protected Definition makeDefinition()
    {
        return library()
                .function(this, "my-fun")
                .returns(Types.SINGLE_INTEGER)
                .param(Types.SINGLE_INTEGER, "first")
                .param(Types.SINGLE_INTEGER, "second")
                .make();
    }

    @Override
    public Sequence call(XPathContext ctxt, Sequence[] args)
            throws XPathException
    {
        Parameters params = checkParams(args);
        long first  = params.asLong(0, true);
        long second = params.asLong(1, true);
        long result = 0;
        return Return.value(result);
    }
}