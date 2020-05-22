public interface Interface_EventHandler extends Disposable
{
    public void handleEvent(final Event... e);
    public void registerListener(final Interface_Listen listener,
            final Event_Type... type);
    public void unregisterListener(final Interface_Listen... listener);
    public void unregisterAllListener();
    public void unregisterAllListener(final Event_Type... type);
    public void processEvents();
    public void processEvents(final int maxTimeInMS);
}