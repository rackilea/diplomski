final class InterfaceTypeAdapterFactory
        implements TypeAdapterFactory {

    // Effectively a singleton totally holding no state
    private static final TypeAdapterFactory interfaceTypeAdapterFactory = new InterfaceTypeAdapterFactory();

    private InterfaceTypeAdapterFactory() {
    }

    // However, let's encapsulate the instantiation
    static TypeAdapterFactory getInterfaceTypeAdapterFactory() {
        return interfaceTypeAdapterFactory;
    }

    @Override
    public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> typeToken) {
        // Checking if it's an interface
        return !typeToken.getRawType().isInterface()
                // If it's not, then just let Gson pick up a proper type adapter
                ? null
                // Otherwise return a null-safe custom type adapter
                : new InterfaceTypeAdapter<T>(gson).nullSafe();
    }

    private static final class InterfaceTypeAdapter<T>
            extends TypeAdapter<T> {

        private static final String TYPE_PROPERTY = "type";
        private static final String DATA_PROPERTY = "data";

        private final Gson gson;

        private InterfaceTypeAdapter(final Gson gson) {
            this.gson = gson;
        }

        @Override
        @SuppressWarnings("resource")
        public void write(final JsonWriter out, final T value)
                throws IOException {
            // Here we're just writing a property value similar to one you did
            out.beginObject();
            out.name(TYPE_PROPERTY);
            out.value(value.getClass().getName());
            out.name(DATA_PROPERTY);
            gson.toJson(value, value.getClass(), out);
            out.endObject();
        }

        @Override
        public T read(final JsonReader in)
                throws IOException {
            try {
                // Deserialization is more complex
                // Make sure that the current value is an object
                in.beginObject();
                final String name = in.nextName();
                final Object value;
                switch ( name ) {
                // If the first property in the stream was type...
                case TYPE_PROPERTY:
                    final String type = in.nextString();
                    // Then require the next property to be data
                    if ( !in.nextName().equals(DATA_PROPERTY) ) {
                        throw new MalformedJsonException("Expected " + DATA_PROPERTY + " at " + in);
                    }
                    // And delegate the deserialization to Gson
                    value = gson.fromJson(in, Class.forName(type));
                    break;
                // If some some reason, the order of data and type was messed...
                case DATA_PROPERTY:
                    // Then store the current value as a JSON tree to deserialize it later
                    // It consumes more memory than the `case TYPE_PROPERTY` case, and you can consider this one as the worst case
                    final JsonElement jsonElement = gson.fromJson(in, JsonElement.class);
                    if ( !in.nextName().equals(TYPE_PROPERTY) ) {
                        throw new MalformedJsonException("Expected " + TYPE_PROPERTY + " at " + in);
                    }
                    // Restore the value from the tree
                    value = gson.fromJson(jsonElement, Class.forName(in.nextString()));
                    break;
                default:
                    throw new MalformedJsonException("Unrecognized " + name + " at " + in);
                }
                if ( in.hasNext() ) {
                    throw new IllegalStateException("Unexpected " + in.nextName() + " at " + in);
                }
                in.endObject();
                @SuppressWarnings("unchecked")
                final T castValue = (T) value;
                return castValue;
            } catch ( final ClassNotFoundException ex ) {
                throw new IOException(ex);
            }
        }

    }

}