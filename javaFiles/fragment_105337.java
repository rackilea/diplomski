public class Dog extends Animal {
  private int dogProperty = 8;

  //Override method of base class
  public void makeSound() {
    System.out.println("Woof");
  }

  public int getDogProperty(){
    return this.dogProperty;
  }
}