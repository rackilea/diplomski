class ASerializer implements JsonSerializer<A>
{

    public JsonElement serialize(A t, Type type, JsonSerializationContext jsc)
    {
        JsonArray ja = new JsonArray();
        ja.add(new JsonPrimitive(t.a));
        ja.add(new JsonPrimitive(t.b));
        ja.add(new JsonPrimitive(t.isDog));
        return ja;
    }

}