private DummyObj createDummy() {
  return new DummyObj() {
    private final String[] alphabet= {"a", "b", "c", "d", "e" };
    private final String[] numeric= {"1", "2", "3", "4", "5" };
    AtomicInteger idx;
    String currentAlphabet;
    String currentNumeric;
    int currentIndex;

    @Override public boolean next() { /* ... */ }
    @Override public int nextInt() { /* ... */ }
    @Override public byte nextByte() { /* ... */ }
    @Override public String innerMethod() { /* ... */ }
  };
}