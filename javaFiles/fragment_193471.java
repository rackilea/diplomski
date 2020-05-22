public void operation() {
  String filename = /* such way to retrieve filename, ie database access */
  try (InputStream in = Files.newInputStream(fileSystem.getPath(filename))) {
    new StreamProcessor().process(in);
  } catch (IOException e) {
    /* business error management */
  }
}