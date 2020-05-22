public interface CanFly {
    void fly();
}

public class Eagle implements CanFly {
    @Override
    public void fly() {
        //...
    }
}

public class Penguin {
    //I cannot fly, I do not need to implement CanFly
}