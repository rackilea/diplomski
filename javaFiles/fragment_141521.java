public class FooRuntimeTypeAdapter implements JsonDeserializer<FooRuntime>, JsonSerializer<FooRuntime>
{
    public FooRuntime deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException
    {
        int runtime;
        try
        {
            runtime = json.getAsInt();
        }
        catch (NumberFormatException e)
        {
            runtime = 0;
        }
        return new FooRuntime(runtime);
    }

    public JsonElement serialize(FooRuntime src, Type typeOfSrc, JsonSerializationContext context)
    {
        return new JsonPrimitive(src.getValue());
    }
}