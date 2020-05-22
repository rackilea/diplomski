@SuppressWarnings("resource")
private static void trim(final int maxStringLength, final Reader reader, final Writer writer)
        throws IOException {
    // a specifically configured IDEA complains for the unclosed jsonReader, but invoking the `close` method is a like a chain and sometimes undesirable
    @SuppressWarnings("all")
    final JsonReader jsonReader = new JsonReader(reader);
    // the same goes to jsonWriter
    @SuppressWarnings("all")
    final JsonWriter jsonWriter = new JsonWriter(writer);
    for ( JsonToken token; (token = jsonReader.peek()) != END_DOCUMENT; ) {
        switch ( token ) {
        case BEGIN_ARRAY:
            // merely reflect a BEGIN_ARRAY token
            jsonReader.beginArray();
            jsonWriter.beginArray();
            break;
        case END_ARRAY:
            // merely reflect an END_ARRAY token
            jsonReader.endArray();
            jsonWriter.endArray();
            break;
        case BEGIN_OBJECT:
            // merely reflect a BEGIN_OBJECT token
            jsonReader.beginObject();
            jsonWriter.beginObject();
            break;
        case END_OBJECT:
            // merely reflect an END_OBJECT token
            jsonReader.endObject();
            jsonWriter.endObject();
            break;
        case NAME:
            // merely reflect NAME tokens (or trim?)
            jsonWriter.name(jsonReader.nextName());
            break;
        case STRING:
            // trimming a STRING token if necessary
            final String string = jsonReader.nextString();
            jsonWriter.value(string.length() > maxStringLength ? string.substring(0, maxStringLength) : string);
            break;
        case NUMBER:
            // NUMBER tokens are a bit complex because JSON only denotes a double number that can be literally an integer
            final String rawNumber = jsonReader.nextString();
            try {
                // try to write the biggest integer number supported by Java, floating points also fail to be parsed as long values
                jsonWriter.value(parseLong(rawNumber));
            } catch ( final NumberFormatException nex1 ) {
                try {
                    // not a long value, then perhaps it's a double value?
                    jsonWriter.value(parseDouble(rawNumber));
                } catch ( final NumberFormatException nex2 ) {
                    // can't think of specific cases here...
                    throw new AssertionError("Must not happen", nex2);
                }
            }
            break;
        case BOOLEAN:
            // merely reflect BOOLEAN tokens
            jsonWriter.value(jsonReader.nextBoolean());
            break;
        case NULL:
            // merely reflect NULL tokens
            jsonReader.nextNull();
            jsonWriter.nullValue();
            break;
        case END_DOCUMENT:
            // fall through, because this type of tokens is checked above, and it's fine to throw an assertion error
        default:
            throw new AssertionError(token);
        }
    }
}