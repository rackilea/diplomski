public final class ExposedGZIPInputStream extends GZIPInputStream {

  public ExposedGZIPInputStream(final InputStream stream) {
    super(stream);
  }

  public ExposedGZIPInputStream(final InputStream stream, final int n) {
    super(stream, n);
  }

  public Inflater inflater() {
    return super.inf;
  }
}
...
final ExposedGZIPInputStream gzip = new ExposedGZIPInputStream(...);
...
final Inflater inflater = gzip.inflater();
final long read = inflater.getBytesRead();