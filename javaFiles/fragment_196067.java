public class B {

  public static void main(String[] args) {
    D.main(args);
  }
}
class D {

  public void foo(E e) {}
  public static void main(String[] args) {
    System.out.println("hello world");
  }
}
class E { }