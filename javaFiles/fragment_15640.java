public abstract class Animal
{
  public String speak();
}

public class Dog extends Animal
{
  public String speak()
  {
    return "woof";
  }
}

public class Cat extends Animal
{
  public String speak()
  {
    return "miaow";
  }
}

public class SomeOtherClass
{
  public String speak(Animal a)
  {
    return a.speak();
  }
}