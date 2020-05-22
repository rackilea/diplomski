public class MyTestObjectTypeAdapterFactory extends CustomizedTypeAdapterFactory<MyTestObject>
{
    public MyTestObjectTypeAdapterFactory()
    {
        super(MyTestObject.class);
    }

    @Override
    protected void beforeWrite(MyTestObject source, JsonElement toSerialize)
    {
        //you could convert back the other way here, I let mongo's document parser take care of that.
    }

    @Override
    protected void afterRead(JsonElement deserialized)
    {
        JsonObject timestamp = deserialized.getAsJsonObject().get("timestamp").getAsJsonObject();
        deserialized.getAsJsonObject().remove("timestamp");
        deserialized.getAsJsonObject().add("timestamp",timestamp.get("$numberLong"));
    }
}