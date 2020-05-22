public class Entry
    implements JsonSerializable
{
    int value;

    public Entry(int value) 
    {
        this.value = value;
    }

    @Override
    public void serialize(final JsonGenerator jgen,
        final SerializerProvider provider)
        throws IOException
    {
        // Don't do anything if value is not 1...
        if (value != 1)
            return;

        jgen.writeStartObject();
        jgen.writeNumberField("value", 1);
        jgen.writeEndObject();
    }

    @Override
    public void serializeWithType(final JsonGenerator jgen,
        final SerializerProvider provider, final TypeSerializer typeSer)
        throws IOException
    {
        serialize(jgen, provider);
    }
}