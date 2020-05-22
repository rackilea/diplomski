public class EatingDecorator implements Animal {
  private Animal target;
  private int counter;

  public EatingDecorator(Animal target) {
    this.target = target;
  }

  @Override
  public void eat() {
    target.eat();
    counter++;
  }

  public int getCounter() {
    return counter;
  }
}