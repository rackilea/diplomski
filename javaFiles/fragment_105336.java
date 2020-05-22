public class Cat extends Animal {
  private int catProperty = 5;

  //Override method of base class
  public void makeSound() {
    System.out.println("Meow");
  }

  public int getCatProperty(){
    return this.catProperty;
  }
}