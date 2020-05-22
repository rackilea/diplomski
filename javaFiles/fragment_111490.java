public class Run extends Interface {
  public static void main(String[] argv) {
    test.bar(new Run());       
  }

  public String foo() {
    return "Hello from Java!";
  }
}