public class EmptyStringFailFastJsonReader
        extends JsonReader {

    public EmptyStringFailFastJsonReader(final Reader in) {
        super(in);
    }

    @Override
    public JsonToken peek()
            throws IOException {
        try {
            return super.peek();
        } catch ( final EOFException ex ) {
            throw new JsonSyntaxException(ex);
        }
    }

}