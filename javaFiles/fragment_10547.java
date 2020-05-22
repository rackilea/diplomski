final class MyCollectors {

  private MyCollectors() {}

  public static Collector<Byte, ?, byte[]> toByteArray() {
    return Collector.of(ByteArrayOutputStream::new, ByteArrayOutputStream::write, (baos1, baos2) -> {
      try {
        baos2.writeTo(baos1);
        return baos1;
      } catch (IOException e) {
        throw new UncheckedIOException(e);
      }
    }, ByteArrayOutputStream::toByteArray);
  }
}