class Range {
  private final int low, high;
  Range(int low, int high) {
    if (low > high) throw new IllegalArgumentException("low can't be greater than high");
    this.low = low;
    this.high = high;
  }
}