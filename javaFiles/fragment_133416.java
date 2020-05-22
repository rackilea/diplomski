public class JsonStreamFilter
{
    /**
     * Filter out all properties with names included in the `propertiesToRemove` list.
     * 
     * @param reader JsonReader to read in the JSON token
     * @param writer JsonWriter to accept modified JSON tokens
     * @param propertiesToRemove List of property names to remove
     * @throws IOException
     * @see Gson docs at https://sites.google.com/site/gson/streaming
     */
    public static void streamFilter(
        final JsonReader reader,
        final JsonWriter writer,
        final List<String> propertiesToRemove
    ) throws IOException
    {
        while ( true )
        {
            JsonToken token = reader.peek();
            switch ( token )
            {
                case BEGIN_ARRAY:
                    reader.beginArray();
                    writer.beginArray();
                    break;
                case END_ARRAY:
                    reader.endArray();
                    writer.endArray();
                    break;
                case BEGIN_OBJECT:
                    reader.beginObject();
                    writer.beginObject();
                    break;
                case END_OBJECT:
                    reader.endObject();
                    writer.endObject();
                    break;
                case NAME:
                    String name = reader.nextName();

                    // Skip all nested structures stemming from this property
                    if ( propertiesToRemove.contains( name ) )
                    {
                        reader.skipValue();
                        break;
                    }

                    writer.name( name );
                    break;
                case STRING:
                    String s = reader.nextString();
                    writer.value( s );
                    break;
                case NUMBER:
                    String n = reader.nextString();
                    writer.value( new BigDecimal( n ) );
                    break;
                case BOOLEAN:
                    boolean b = reader.nextBoolean();
                    writer.value( b );
                    break;
                case NULL:
                    reader.nextNull();
                    writer.nullValue();
                    break;
                case END_DOCUMENT:
                    return;
            }
        }
    }
}