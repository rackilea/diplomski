Stream<String> stream = JavaConverters.asScalaIteratorConverter(
  new Iterator<String>() {
    int i = 0;
    public boolean hasNext() { return true; }
    public void remove() { throw new UnsupportedOperationException(); }
    public String next() { return Integer.toString(i++); }
  }
).asScala().toStream();