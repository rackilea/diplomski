public class Animal {
  public static void testClassMethod() {
      System.out.println("The class" + " method in Animal.");
  }
  public void testInstanceMethod() {
      System.out.println("The instance " + " method in Animal.");
  }
}

public class Kangaroo extends Animal {
  public static void testClassMethod() {
      System.out.println("The class method" + " in Kangaroo.");
  }
  public void testInstanceMethod() {
      System.out.println("The instance method" + " in Kangaroo.");
  }

  public static void main(String[] args) {
      Kangaroo myRoo = new Kangaroo();
      Animal myAnimal = myRoo;
      myRoo.testInstanceMethod();
      myAnimal.testInstanceMethod();
      Kangaroo.testClassMethod();
      Animal.testClassMethod();
  }
}