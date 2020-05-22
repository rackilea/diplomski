final class MyClass implements TypeAdapterFactory {
  @Override
  public <T> TypeAdapter<T> create(final Gson gson, final TypeToken<T> tokenType) {
    final MyClass THIS = this;

    return new TypeAdapter<T>() {
      @Override
      public T read(JsonReader reader) throws IOException {
        Class<?> clazz = Class.forName(classpath);

        TypeToken<T> token = (TypeToken<T>) TypeToken.get(clazz);
        TypeAdapter<T> adapter = gson.getDelegateAdapter(THIS, token);
        JsonElement tree = gson.getAdapter(JsonElement.class).read(reader);
        T out = adapter.fromJsonTree(tree);

        return out;
      }

      @Override
      public void write(JsonWriter writer, T value) throws IOException {
      }
    };
  }
}