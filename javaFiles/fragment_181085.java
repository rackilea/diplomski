public abstract class Animal {
    abstract void eat(Food f);
}

public class Pig extends Animal {
    @Override
    void eat(Carrot c) { ... }
}