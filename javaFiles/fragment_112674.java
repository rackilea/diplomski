class MyClass {
  private static MyClass myClass = new MyClass();
  private static final Object obj = new Object();
  public MyClass() {
    System.out.println(obj); // will print null once
  }
}