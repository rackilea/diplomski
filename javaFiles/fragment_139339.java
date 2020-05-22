final class BooleanToIntTypeAdapter
        extends TypeAdapter<Integer> {

    // Public constructors may be evil, and let expose as less as possible
    // Gson can still instantiate this type adapter itself  
    private BooleanToIntTypeAdapter() {
    }

    @Override
    @SuppressWarnings("resource")
    public void write(final JsonWriter out, final Integer value)
            throws IOException {
        // If the given value is null, we must write the `null` token to the output JSON tokens stream anyway in order not to break JSON documents
        if ( value == null ) {
            out.nullValue();
            return;
        }
        // Let's assume that we can accept either 0 or 1 that are mapped to false and true respectively
        switch ( value ) {
        case 0:
            out.value(false);
            break;
        case 1:
            out.value(true);
            break;
        default:
            // Or throw an exception as fast as we can
            throw new IllegalArgumentException("Cannot convert " + value + " to a boolean literal");
        }
    }

    @Override
    public Integer read(final JsonReader in)
            throws IOException {
        // Peek the next token type, and if it's null, then return null value too
        if ( in.peek() == NULL ) {
            return null;
        }
        // Otherwise parse the next token as boolean and map it either to 1 or 0
        return in.nextBoolean() ? 1 : 0;
    }

}