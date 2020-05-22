public interface Flyer {
  public void fly();
}   

public class Bird implements Flyer {
  @Override
  public void fly() {
    System.out.println("I'm flying");
  }   
}   

public class Airplane implements Flyer {
  @Override
  public void fly() {
    System.out.println("I'm inanimate and flying");
  }   
}   

// then you can have a method like so:
public void makeFly(Flyer flyer) {
  flyer.fly();
} 

// or make a list like so:
List<Flyer> fliers = Arrays.asList(new Airplane(), new Bird());