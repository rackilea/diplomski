final class JsonFailSafeTypeAdapterFactory
        implements TypeAdapterFactory {

    private static final TypeAdapterFactory instance = new JsonFailSafeTypeAdapterFactory();

    private JsonFailSafeTypeAdapterFactory() {
    }

    static TypeAdapterFactory get() {
        return instance;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // We can support non-primitive types only
        if ( typeToken.getRawType().isPrimitive() ) {
            return null;
        }
        final TypeAdapter<T> delegateTypeAdapter = gson.getAdapter(typeToken);
        return new JsonFailSafeTypeAdapter<>(delegateTypeAdapter);
    }

    private static final class JsonFailSafeTypeAdapter<T>
            extends TypeAdapter<T> {

        private final TypeAdapter<T> delegateTypeAdapter;

        private JsonFailSafeTypeAdapter(final TypeAdapter<T> delegateTypeAdapter) {
            this.delegateTypeAdapter = delegateTypeAdapter;
        }

        @Override
        public void write(final JsonWriter out, final T value)
                throws IOException {
            delegateTypeAdapter.write(out, value);
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            try {
                return delegateTypeAdapter.read(in);
            } catch ( final MalformedJsonException | RuntimeException ignored ) {
                // Once we get into unexpected JSON token, let's *always* consider a fallback to the default value
                // Well, the default is always `null` anyway, but we'll do more work
                return fallback(in);
            }
        }

        private static <T> T fallback(final JsonReader in)
                throws IOException {
            final JsonToken jsonToken = in.peek();
            switch ( jsonToken ) {
            case BEGIN_ARRAY:
            case BEGIN_OBJECT:
            case NAME:
            case STRING:
            case NUMBER:
            case BOOLEAN:
            case NULL:
                // Assume we're at the beginning of a complex JSON value or a JSON primitive
                in.skipValue();
                break;
            case END_ARRAY:
                // Not sure if we skipValue() can fast-forward this one
                in.endArray();
                break;
            case END_OBJECT:
                // The same
                in.endObject();
                break;
            case END_DOCUMENT:
                // do nothing
                break;
            default:
                throw new AssertionError(jsonToken);
            }
            // Just return null (at least at the moment)
            return null;
        }

    }

}