enum Enum1 {
  DELETE(10, "aaaa1"),
  CANCEL(11, "bbb1"),
  APPEND(12, "cccc1");

  public final String description;
  public final int value;

  private Enum1(int value, String description) {
    this.description = description;
    this.value = value;
  }
}

enum Enum2  {
  DELETE(20, "aaaa2"),
  CANCEL(21, "bbb2"),
  APPEND(22, "cccc2");

  public final String description;
  public final int value;

  private Enum2(int value, String description) {
    this.description = description;
    this.value = value;
  }
}