public class Animal
{
}

public class Dog extends Animal
{
}

public class Cat extends Animal
{
}

public class SomeOtherClass
{
  public abstract String speak(Animal a)
  {
    String word = "";

    if (a instanceof Dog)
    {
      word = "woof";
    }
    else if (a instanceof Cat)
    {
      word = "miaow";
    }

    return word;
  }
}