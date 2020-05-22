public class Bird() {
    public void eat() { 
        ....
    }
}

public interface FlyingBehaviour() {
    void fly();
}

public abstract class FlyingBird extends Bird implements FlyingBehaviour() {
    ...
}

public class Eagle extends FlyingBird {
    ...
}

public class Penguin extends Bird {
    ...
}

FlyingBird bird = new Eagle();
bird.fly();

FlyingBird bird = new Penguin(); //Compilation Error - Penguins cant fly!