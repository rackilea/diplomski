public void operation() {
  String filename = /* such way to retrieve filename, ie database access */
  try (InputStream in = Files.newInputStream(fileSystem.getPath(filename))) {
    /* file content handling */
  } catch (IOException e) {
    /* business error management */
  }
}