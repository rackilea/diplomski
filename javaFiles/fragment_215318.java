public static <TT> TypeAdapterFactory newFactory(
    final TypeToken<TT> type, final TypeAdapter<TT> typeAdapter) {
  return new TypeAdapterFactory() {
    @SuppressWarnings("unchecked") // we use a runtime check to make sure the 'T's equal
    @Override public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> typeToken) {
      return typeToken.equals(type) ? (TypeAdapter<T>) typeAdapter : null;
    }
  };
}