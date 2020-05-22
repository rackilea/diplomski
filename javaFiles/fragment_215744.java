public class APIContext extends Context
{
    public void callback( String action, String result )
    {
        /* ... */
    }
}

public class SomeClass extends APIContext
{
    @Override
    public void callback( String action, String result )
    {
        /* ... */
    }
}

public class api
{
    private APIContext callerContext = null;

    public api( APIContext context )
    {
        this.callerContext = context;
    }

    public void callback( String action, String result )
    {
        callerContext.callback( action, result );
    }
}