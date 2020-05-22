// made class generic
public abstract class Animal<T extends Animal<T>> {

    public abstract void follow(T a);

}

// parametrizes with own type
public class Fish extends Animal<Fish> {

    @Override
    public void follow(Fish a) {
        // compiles
    }

}