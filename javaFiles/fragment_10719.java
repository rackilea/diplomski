public final class MyMap extends ForwardingSetMultimap<String, Object> {
  private final SetMultimap<String, Object> delegate =
      LinkedHashMultimap.create();

  @Override public SetMultimap<String, Object> delegate() {
    return delegate;
  }

  // add your methods here
}