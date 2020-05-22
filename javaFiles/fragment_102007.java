TypeAdapterFactory immutableListFactory = new TypeAdapterFactory() {
  @Override public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (!(type.getType() instanceof ParameterizedType)
        || !type.getRawType().equals(ImmutableList.class)) {
      return null;
    }

    ParameterizedType parameterizedType = (ParameterizedType) type.getType();
    TypeAdapter<T> delegate = gson.getDelegateAdapter(this, type);
    TypeAdapter<?> elementAdapter = gson.getAdapter(
        TypeToken.get(parameterizedType.getActualTypeArguments()[0]));
    return new ImmutableListAdapter(delegate, elementAdapter);
  }

  class ImmutableListAdapter<E> extends TypeAdapter<ImmutableList<E>> {
    private TypeAdapter<List<E>> delegate;
    private TypeAdapter<E> element;

    ImmutableListAdapter(TypeAdapter<List<E>> delegate, TypeAdapter<E> element) {
      this.delegate = delegate;
      this.element = element;
    }

    @Override public void write(JsonWriter out, ImmutableList<E> value) throws IOException {
      delegate.write(out, value);
    }

    @Override public ImmutableList<E> read(JsonReader in) throws IOException {
      if (in.peek() == JsonToken.NULL) {
        in.nextNull();
        return null;
      }
      ImmutableList.Builder<E> builder = ImmutableList.builder();
      in.beginArray();
      while (in.hasNext()) {
        builder.add(element.read(in));
      }
      in.endArray();
      return builder.build();
    }
  }
};