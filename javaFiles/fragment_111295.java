public interface IBird { //all birds
    public void eat();
    public void walk();
    public void run();
}

public interface IBirdThatCanFly extends IBird { //birds that can fly
    public void fly();
}

public class Ostrich implements IBird { //Ostrich can't fly
    public void eat() { ... }
    public void walk() { ... }
    public void run() { ... }
}