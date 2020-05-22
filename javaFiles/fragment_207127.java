public class JavaMain {
  public static void main(String[] args) {
    A a = new A();
    A.B<String> b = a.new B<String>(a);
  }
}