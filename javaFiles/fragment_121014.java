class Animal {
    public void move() {
        System.out.println("I'm an animal and I can move.");
    }
}

class Cat extends Animal {
    //this means a Cat would change the move behavior from the Animal instance
    @Override
    public void move() {
        System.out.println("I'm a cat and I can move.");
    }
}

class Dog extends Animal {
    //this means a Cat would change the move behavior from the Animal instance
    @Override
    public void move() {
        System.out.println("I'm a dog and I like to run.");
    }
    public void bark() {
        System.out.println("I can bark!");
    }
}

public class AnimalTest {
    public static void main(String[] args) {
         //it will take the behavior of the Animal class reference
         Animal animal = new Animal();
         //it will take the behavior of the Cat class reference
         Animal cat = new Cat();
         //it will take the behavior of the Dog class reference
         Animal dog = new Dog();
         //this will invoke the Animal#move method
         animal.move();
         //this will invoke the Cat#move method because it was overriden in the Cat class
         cat.move();
         //this will invoke the Dog#move method because it was overriden in the Dog class
         dog.move();
         //this line won't compile if uncommented because not all animals can bark.
         //dog.bark();
         //if you want to make the dog barks, then you should use the downcasting
         ((Dog)dog).bark();
         //note that this will only work for Dog class reference, not for any other class
         //uncomment this line and the code will compile but throw a ClassCastException
         //((Dog)cat).bark();
    }
}