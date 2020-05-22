public class PActivity {
...
    public final boolean onEventSocket(args)
    {
        if (method_should_be_called)
        {
            eventSocketImpl(args);
        }
    }

    protected boolean eventSocketImpl(args)
    {
        // default behaviour
    }
}

public class PMenu extends PActivity {
    @Override
    protected boolean eventSocketImpl(args)
    {
        // overridden behaviour
    }
}