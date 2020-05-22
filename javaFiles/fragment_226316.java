public class ConstructorExp {
  public ConstructorExp() {
    System.out.println("Ctt");
  }

  public static void main(String[] args) {
    System.out.println("Inside Main Methos");
    ConstructorExp example = new ConstructorExp();
    System.out.println("Main");
  }
}