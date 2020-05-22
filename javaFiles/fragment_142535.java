public enum ShapeTypeAdapterFactory implements TypeAdapterFactory {
    INSTANCE;

    private static class ShapeTypeAdapter extends TypeAdapter<BackgroundShape> {
        @Override
        public final void write(JsonWriter out, BackgroundShape value) throws IOException {
            if(value == null) {
                out.nullValue();
                return;
            }

            // Your code goes here
        }

        @Override
        public final BackgroundShape read(JsonReader in) throws IOException {
            if(in.peek() == JsonToken.NULL) {
                in.nextNull();
                return null;
            }

            // Your code goes here      

            // Don't return null, return the new object
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
        if(!BackgroundShape.class.isAssignableFrom(type.getRawType())) {
            return null;
        }

        return (TypeAdapter<T>) new ShapeTypeAdapter();
    }
}