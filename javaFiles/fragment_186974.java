class MyPair {
  public final String feature1;
  public final String feature2;
  public MyPair(String s1, String s2) {
    // Order features so comparison is order-independent.
    if (s1.compareTo(s2) <= 0) { // TODO: null check
      feature1 = s1;
      feature2 = s2;
    } else {
      feature1 = s2;
      feature2 = s1;
    }
  }
  @Override public int hashCode() {
    return (s1 + s2).hashCode(); // TODO: cache for performance.
  }
  @Override public boolean equals(that) {
    return (that instanceof MyPair)
        && (that.feature1.equals(this.feature1))
        && (that.feature2.equals(this.feature2));
  }
}