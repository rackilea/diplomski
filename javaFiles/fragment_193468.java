class MyClass {
  private FileSystem fileSystem;
  private final StreamProcessor processor;

  public MyClass(FileSystem fileSystem, StreamProcessor processor) {
    this.fileSystem = fileSystem;
    this.processor = processor;
  }

  public void operation() {
    String filename = /* such way to retrieve filename, ie database access */
    try (InputStream in = Files.newInputStream(fileSystem.getPath(filename))) {
        processor.process(in);
    } catch (IOException e) {
        /* business error management */
    }
  }
}