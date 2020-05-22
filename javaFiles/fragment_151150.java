public enum Name {
  E1("hello"), E2("world");

  private static final Name[] values = values();

  private Name(String val) {
    System.out.println("val = " + val);
    dump();
  }

  protected void dump() {
    System.out.println("this = " + this + ", values = " + values);
  }
}