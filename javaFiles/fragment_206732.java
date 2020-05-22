public class Dog extends Animal {
  public Dog() {super();} // compilation error here: The constructor Animal() is not visible
  @Override public void say() {
    super.say();
    System.out.printLn("Wuf");
  }
}