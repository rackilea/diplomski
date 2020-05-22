enum Size {
  XL(2), LARGE(1), UNKNOWN(-1), UNKNOWN_2(-2);

  private final int value;
  Size(int val) {
    value = val;
  }

  public int getValue() {
    return value;
  }
}