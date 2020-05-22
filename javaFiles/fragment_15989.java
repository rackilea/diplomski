public class FileLoaderRegistry {
  public static final List<Class<? extends FileLoader>> impls =
      ImmutableList.of(
        YMLFileLoader.class,
        XMLFileLoader.class,
        JsonFileLoader.class
      );
}