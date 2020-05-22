public class MyClass {
  private static int i = 3;

  public static void main(String[] args) {
    MyClass m = new MyClass();
    m.i = 4;

    System.out.println(MyClass.i + ", " + m.i);
  }
}