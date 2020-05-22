public static void main(String args[]) {
  MyClass c = new MyClass() {
    @Override public String get() { return "outer"; }
  };
  System.out.println(c.append(1).get());
}

static abstract class MyClass {
  public abstract String get();

  public MyClass append(final int i) {
    return new MyClass() {
      @Override public String get() {
        return cons(MyClass.this.get(), i);
      }
    };
  }

  public static String cons(String iter, int i) { return iter + " " + i; }
}