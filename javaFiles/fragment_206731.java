public class Animal {
  public void say() {
    System.out.printLn("Animal says:");
  }
  private Animal() {}

  public static class Cat extends Animal {
    public Cat() {super();}
    @Override public void say() {
      super.say();
      System.out.printLn("Meow");
    }
  }
}