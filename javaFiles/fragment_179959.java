// least priority method if both method arguments matching with the calling one
 public void method(String s, Integer i, Object... o) {
    System.out.println("method(String s, Integer i, Object... o)");
  }

  public void method(Object o, Integer i) {
    System.out.println("method(Object o, Integer i)");
  }