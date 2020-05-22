public interface Transport {
    void performOperation(Operation op);
}

public class Car implements Transport {
    public void performOperation(Operation op) { op.operate(this); }
}

public class Bike implements Transport {
    public void performOperation(Operation op) { op.operate(this); }
}