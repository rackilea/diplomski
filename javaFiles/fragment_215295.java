class MyAdapter implements TypeAdapterFactory {

  @Override
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> tokenType) {
    final TypeAdapter<T> delegate = gson.getDelegateAdapter(this, tokenType);

    return new TypeAdapter<T>() {
      @Override
      public void write(JsonWriter out, T value) throws IOException {
        delegate.write(out, value);
      }

      @Override
      public T read(JsonReader arg0) throws IOException {
        T t = delegate.read(arg0);
        if (List.class.isAssignableFrom(tokenType.getRawType())) {
          List<?> list = (List<?>) t;

          return (T) Collections.unmodifiableList(list);
        }

        return t;
      }
    };
  }
}