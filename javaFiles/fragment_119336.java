// Base class for a server sent event
public class ServerEvent 
{
    public static final String TYPEFIELDNAME = "eventType";

    // Event type is used during deserialization to choose the right subclass
    private final String eventType;

    public ServerEvent(String eventType) 
    {
        this.eventType = eventType;
    }

    public String toString()
    {
        return "eventType: " + eventType;
    }
}