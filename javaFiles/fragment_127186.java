public interface AInterface {
    void add();
    void remove();
}

public interface ASubInterface extends AInterface {
    void invalidate();
    void move();
}

public class AClass implements ASubInterface { /* 4 methods */ }
public class BClass implements AInterface { /* 2 methods */ }