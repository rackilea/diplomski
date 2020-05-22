public class OptionalTypeAdapter<E> extends TypeAdapter<Optional<E>> {

    public static final TypeAdapterFactory FACTORY = new TypeAdapterFactory() {

        //@Override
        public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
            Class<T> rawType = (Class<T>) type.getRawType();
            if (rawType != Optional.class) {
                return null;
            }
            final ParameterizedType parameterizedType = (ParameterizedType) type.getType();
            final Type actualType = parameterizedType.getActualTypeArguments()[0];
            final TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(actualType));
            return new OptionalTypeAdapter(adapter);
        }
    };
    private final TypeAdapter<E> adapter;

    public OptionalTypeAdapter(TypeAdapter<E> adapter) {
        this.adapter = adapter;
    }

    @Override
    public void write(JsonWriter out, Optional<E> value) throws IOException {
        if(value == null || !value.isPresent()){
            out.nullValue();
        } else {
            adapter.write(out, value.get());
        }
    }

    @Override
    public Optional<E> read(JsonReader in) throws IOException {
        final JsonToken peek = in.peek();
        if(peek != JsonToken.NULL){
            return Optional.ofNullable(adapter.read(in));
        }
        in.nextNull();
        return Optional.empty();
    }

}