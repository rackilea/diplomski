public static void main(String[] args)
{
    Gson gson = new GsonBuilder().registerTypeAdapter(TimeData.class, new TimeDataDeserializer()).create();
    String json = "{\"MessageType\":\"TimeData\",\"TimeData\":{\"hh\":12,\"mm\":13,\"ms\":15,\"ss\":14}}";
    JsonMessage message = gson.fromJson(json, JsonMessage.class);

    switch(message.MessageType)
    {
        case TimeData:
            TimeData td = new GsonBuilder()
                            .registerTypeAdapter(TimeData.class, new TimeDataDeserializer())
                            .create()
                            .fromJson(json, TimeData.class);
            td.MessageType = message.MessageType
            System.out.println(td.hh);
            break;
        default:
            break;
    }
}

class TimeDataDeserializer implements JsonDeserializer<TimeData>
{
    @Override
    public TimeData deserialize(JsonElement je, Type type, JsonDeserializationContext jdc)  
        throws JsonParseException
    {
        JsonObject jo = je.getAsJsonObject().getAsJsonObject("TimeData");
        Gson g = new Gson();
        return g.fromJson(jo, TimeData.class);
    }
}