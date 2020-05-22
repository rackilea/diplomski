static javafx.scene.image.Image loadImage(Class<?> source, String path) {
  final InputStream is = source.getResourceAsStream(path);
  if (null == is) {
    throw new IllegalStateException("Could not load image from " + source + " path: " + path);
  }
  try (is) { // Java 9 -> you may want to use InputStream is2 = is
    return new javafx.scene.image.Image(is); // use is2 for Java < 9
  }
}