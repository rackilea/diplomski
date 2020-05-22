public abstract class Animal {
    public abstract void say();
}

public class Dog extends Animal {

    @Override
    public void say() {
        System.out.println("Bark");
    }
}

public class Cat extends Animal {

    @Override
    public void say() {
        System.out.println("Meow");
    }
}