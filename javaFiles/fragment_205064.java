public EventHandler()
{
    listeners = new HashMap<Event_Type, ArrayList<Interface_Listen>>();
    // add the arraylist for every Eventtype
    for (Event_Type e : Event_Type.values())
    {
        listeners.put(e, new ArrayList<Interface_Listen>());
    }
    events = new LinkedList<Event>();
}

@Override
public void handleEvent(final Event... e)
{
    for (Event event : e)
    {
        events.push(event);
    }
}

@Override
public void unregisterListener(final Interface_Listen... listener)
{
    for (Event_Type e : Event_Type.values())
    {
        for (Interface_Listen interface_Listen : listener)
        {
            listeners.get(e).remove(interface_Listen);
        }
    }
}

@Override
public void processEvents()
{
    while (events.size() != 0)
    {
        // get the first element and delete it
        Event e = events.pop();
        for (Interface_Listen l : listeners.get(e.getType()))
        {
            l.handleEvent(e);
        }
    }
}

@Override
public void processEvents(final int maxTimeInMS)
{
    int startSize = 0;
    if (events.size() != 0)
    {
        startSize = events.size();
        Logger.log("Processing Events: " + events.size());
    }
    long startTime = TimeUtils.millis();

    while (events.size() != 0)
    {
        // get the first element and delete it
        Event e = events.pop();
        for (Interface_Listen l : listeners.get(e.getType()))
        {
            l.handleEvent(e);
        }
        // stop handling if time is up
        if (startTime - TimeUtils.millis() > maxTimeInMS)
        {
            Logger.log("Handled " + (events.size() - startSize) + " Events");
            break;
        }
    }
}

@Override
public void registerListener(final Interface_Listen listener,
        Event_Type... type)
{
    for (Event_Type event_Type : type)
    {
        listeners.get(event_Type).add(listener);
    }
}

@Override
public void unregisterAllListener()
{
    Logger.log("UnregisterAll");
    for (Event_Type e : Event_Type.values())
    {
        listeners.get(e).clear();
    }
}

@Override
public void unregisterAllListener(final Event_Type... type)
{
    for (Event_Type event_Type : type)
    {
        listeners.get(event_Type).clear();
    }
}

@Override
public void dispose()
{
    unregisterAllListener();
    events.clear();
    listeners.clear();
}
}