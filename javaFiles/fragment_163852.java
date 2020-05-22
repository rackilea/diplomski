public class CollectionImplementationTypeAdapterFactory implements TypeAdapterFactory {
  @Override
  public <T> TypeAdapter<T> create(Gson gson, TypeToken<T> type) {
    if (!type.getRawType().equals(CollectionImplementation.class)) {
      return null;
    }
    try {
      Field factoriesField = Gson.class.getDeclaredField("factories");
      factoriesField.setAccessible(true);
      @SuppressWarnings("unchecked")
      List<TypeAdapterFactory> factories = (List<TypeAdapterFactory>) factoriesField.get(gson);
      TypeAdapterFactory typeAdapterFactory = factories.stream().filter(f -> f instanceof ReflectiveTypeAdapterFactory).findAny().get();
      return typeAdapterFactory.create(gson, type);
    } catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException exception) {
      return null;
    }
  }
}