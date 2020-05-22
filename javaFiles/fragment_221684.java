public abstract class Animal {
  public abstract String speak();
}
public class Dog extends Animal {
  public String speak() { return "woof!"; }
}
public class Duck extends Animal {
  public String speak() { return "quack!"; }
}

Animal a = Zoo.getRandomAnimal();
a.speak();