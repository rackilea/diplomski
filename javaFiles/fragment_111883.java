public abstract class Animal {
    // other stuff here
    public abstract void makeSound();
}
public class Dog extends Animal {
    // other stuff here
    @Override
    public void makeSound() {
        bark();
    }
    private void bark() {
        // bark here
    }
}
public class Cat extends Animal {
    // other stuff here
    @Override
    public void makeSound() {
        meow();
    }
    private void meow() {
        // meow here
    }
}