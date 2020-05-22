public abstract class Animal {
  // common fields
   public Animal (int weight, int height) {
    // initialize
   }

   public abstract sting giveSound();
}

public class Dog extends Animal {
   @Override
   public  sting giveSound(){
     return "Wooff";
}


public class Cat extends Animal {
   @Override
   public  sting giveSound(){
     return "Meaw";
}

public class Rabbit extends Animal {
   @Override
   public  sting giveSound(){
     return "";
}