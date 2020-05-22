class Animal {  
        public Animal() {
    System.out.println("A new animal has been created!");
   }
   public void sleep() { 
    System.out.println("An animal sleeps...");
  }
  public void eat() {
    System.out.println("An animal eats..."); }
  }
  class Bird extends Animal {
   public Bird() {
    super();
    System.out.println("A new bird has been created!");
   }
   @Override
   public void sleep() {
    System.out.println("A bird sleeps...");
   }
    @Override
    public void eat() {
    System.out.println("A bird eats...");
    }
    }
    class Dog extends Animal {
     public Dog() {
    super();
    System.out.println("A new dog has been created!");
    }
     @Override
     public void sleep() {
    System.out.println("A dog sleeps...");
    }
     @Override
     public void eat() {
     System.out.println("A dog eats...");
       }
      }
     public class MainClass {
     public static void main(String[] args) {
      Animal animal = new Animal();
      Bird bird = new Bird();
      Dog dog = new Dog();
      System.out.println();

    animal.sleep();
    animal.eat();
    bird.sleep();
    bird.eat();
    dog.sleep();
    dog.eat();}
    }