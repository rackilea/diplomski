public class MyLoader {
  @Inject Map<String, FileLoader> fileLoaderMap;

  public void load(File file, String type) {
    FileLoader fileLoader = fileLoaderMap.get(type);
    if (fileLoader == null) {
      throw new IllegalArgumentException("No file loader for files of type " + type);
    }
    fileLoader.load(file);
  }
}