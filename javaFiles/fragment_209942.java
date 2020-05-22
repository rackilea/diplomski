public class Animal
{
     public void speak()
     {
          System.out.println("BLARGHGH");
     }
}

public class Dog extends Animal
{
     @Override
     public void speak()
     {
          System.out.println("Woof");
     }
}

public class Cat extends Animal
{
     @Override 
     public void speak()
     {
          System.out.println("Meow");
     }

     public void throwUpFurball()
     {
          System.out.println("So fluffy!");
     }
}

public class Test()
{
     public static void main(final String args[])
     {
          Animal animal1 = new Animal(); 
          animal1.speak(); // BLARGHGH
          animal1.throwUpFurball(); // Compilation error - method not found. It will ask for casting

          Animal animal2 = new Cat();
          animal2.speak(); // Meow
          ((Cat)animal2).throwUpFurball(); // Must be cast, because throwUpFurball does not exist in Animal

          Animal animal3 = new Dog();
          animal3.speak(); // Woof
          ((Cat)animal3).throwUpFurball(); // Compiles, but throws ClassCastException at runtime, because the object type of animal3 is Dog

          Cat animal4 = new Cat();
          animal4.speak(); // Meow
          animal4.throwUpFurball(); // No casting necessary, because animal4 is of type Cat

          Object animal5 = new Animal();
          animal5.speak(); // Again, compilation problem. The type Object does not contain the speak() API, so it will require casting.
     }
}