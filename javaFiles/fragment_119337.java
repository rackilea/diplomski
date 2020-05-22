public class EventA extends ServerEvent 
{   
    private static final String EVENTTYPE = "eventa";
    private int data;

    public EventA() 
    {
        super(EVENTTYPE);
    }

    // Helper function to register this class with ServerEventDeserializer
    public static void register(ServerEventDeserializer deserializer) 
    {
        deserializer.registerEvent(EVENTTYPE, EventA.class);
    }

    public String toString()
    {
        return super.toString() + ", data = " + data;
    }
}

public class EventB extends ServerEvent 
{   
    private static final String EVENTTYPE = "eventb";
    private String name;

    public EventB() 
    {
        super(EVENTTYPE);
    }

    // Helper function to register this class with ServerEventDeserializer
    public static void register(ServerEventDeserializer deserializer) 
    {
        deserializer.registerEvent(EVENTTYPE, EventB.class);
    }

    public String toString()
    {
        return super.toString() + ", name = " + name;
    }
}