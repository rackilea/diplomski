class MyClass {
  private static MyClass myClass = new MyClass();
  private static MyClass myClass2 = new MyClass();
  public MyClass() {
    System.out.println(myClass);
    System.out.println(myClass2);
  }
}