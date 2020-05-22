class MyEnum extends java.lang.Enum<MyEnum> {
  public static final Sample FOO;
  // synthetic
  private static final Sample[] $VALUES;

  static {
    FOO = new MyEnum("FOO", 0);
    $VALUES = new MyEnum[] {FOO};
  }

  private MyEnum(String name, int ordinal) {
    super(name, ordinal);
  }

  // and other helpers
  public static MyEnum[] values() { /* $VALUES */ }
  public static MyEnum valueOf(String name) { /* $VALUES lookup */ }
}