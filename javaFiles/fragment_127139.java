public interface Animal {
  public void move();
}

public class Bird implements Flyer, Animal {
  @Override
  public void fly() {
    System.out.println("I'm flying");
  }   

  @Override
  public void move() {
    fly();
  }
}

// now I can do:
Bird bird = new Bird();
Flyer flyer = new Bird();
Animal animal = new Bird();