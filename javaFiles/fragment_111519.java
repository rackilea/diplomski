public abstract class WrappedRange<C extends Comparable> {
  private final Range<C> range;

  protected WrappedRange(Range<C> range) {
    this.range = range;
  }

  public boolean contains(String incoming) {
    try {
      C value = convert(incoming);
    } catch (Exception ex) {
      return false;
    }
    return range.contains(value);
  }

  protected abstract C convert(String incoming);
}

class WrappedLongRange extends WrappedRange<Long> {
  private final int base;

  WrappedLongRange(Range<Long> range, int base) {
    super(range);
    this.base = base;
  }

  @Override
  protected Long convert(String incoming) {
    return Long.valueOf(incoming, base);
  }
}