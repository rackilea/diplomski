// This class handles the polymorphic deserialization of ServerEvent class
public class ServerEventDeserializer implements JsonDeserializer<ServerEvent>
{
    // Gson engine
    private Gson gson;

    // Map of subclasses
    private Map<String, Class<? extends ServerEvent>> eventRegistry;

    public ServerEventDeserializer()
    {
        gson = new Gson();
        eventRegistry = new HashMap<String, Class<? extends ServerEvent>>();
    }

    // Registers a ServerEvent subclass
    public void registerEvent(String event, Class<? extends ServerEvent> eventInstanceClass)
    {
        eventRegistry.put(event, eventInstanceClass);
    }

    @Override
    public ServerEvent deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        try
        {
            // Get the JSON object
            JsonObject commandObject = json.getAsJsonObject();

            // Read the field named "ServerEvent.TYPEFIELDNAME"
            JsonElement commandTypeElement = commandObject.get(ServerEvent.TYPEFIELDNAME);

            // Query the eventRegistry map to instance the right subclass
            Class<? extends ServerEvent> commandInstanceClass = eventRegistry.get(commandTypeElement.getAsString());
            ServerEvent command = gson.fromJson(json, commandInstanceClass);

            return command;
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }
}