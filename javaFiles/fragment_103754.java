final class FlatErrorCodeTypeAdapter
        extends TypeAdapter<ErrorCode> {

    private FlatErrorCodeTypeAdapter() {
    }

    @Override
    public void write(final JsonWriter out, final ErrorCode errorCode)
            throws IOException {
        // very bad idea - the serializer may be in a bad state and we assume the host object is being written
        out.value(errorCode.code);
        out.name("message");
        out.value(errorCode.message);
    }

    @Override
    public ErrorCode read(final JsonReader in)
            throws IOException {
        // now fighting with the bad idea being very fragile assuming that:
        // * the code field appears the very first property value
        // * we ignore the trailing properties and pray the host object does not have "message" itself
        // * no matter what "message" is -- it simply does not have sense
        final int code = in.nextInt();
        return ErrorCode.valueByCode(code);
    }

}