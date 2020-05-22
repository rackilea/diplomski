ActivityManager(myActivityMap, ClientFactory.INSTANCE.getEventBus());

...

public class MyActivity extends AbstractActivity implements ContextChangedEvent.Handler
{
    public MyActivity()
    {
    }

    @override
    public void onContextChanged()
    {
        // do Stuff
    }

    @override
    public void start(AcceptsOneWidget panel, EventBus eventBus) {
        eventBus.addHandler(ContextChangedEvent.TYPE, this);
    }
}