public interface MyFactory {
    Strategy get(String type);
}

// Could be an abstract class
public interface Strategy {
    void doStuff();
}