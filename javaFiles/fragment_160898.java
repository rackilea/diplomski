public enum MyEnum {
  ONE("uno"), TWO("dos");
  MyEnum(String v) {
    value = v;
  }
  private String value;
  public String getValue() {
    return value;
  }
}