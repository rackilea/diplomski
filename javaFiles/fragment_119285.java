public class DefalutMethodsTest implements DefaultMethods{
  public static void main(String[] args) {
    new DefalutMethodsTest().example();
  }
  @Override
  public void example() {
    System.out.println("implementer call");
    DefaultMethods.super.example(); 
  }
}