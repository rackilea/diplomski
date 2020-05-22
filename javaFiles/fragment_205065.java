public class Event
{
private Event_Type type;
private HashMap<String, String> m_messages;

public Event(final Event_Type e, final Event_Message... m)
{
    m_messages = new HashMap<String, String>();
    for (Event_Message message : m)
    {
        m_messages.put(message.m_key, message.m_value);
    }
    type = e;
}


public Event_Type getType()
{
    return type;
}

public void addMessages(final Event_Message... m)
{
    for (Event_Message event_Message : m)
    {
        m_messages.put(event_Message.m_key, event_Message.m_value);
    }
}

public String getMessage(final String name)
{
    if (m_messages.get(name) == null)
    {
        Logger.error("Message not found: " + name);
    }

    // if null return an empty string
    return m_messages.get(name) != null ? m_messages.get(name) : "";
}

public void clearMessages()
{
    m_messages.clear();
}
}