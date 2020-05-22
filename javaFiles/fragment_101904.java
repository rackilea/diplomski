public interface Strategy {

    public void doSomething();

}

public class Inventory {

    Strategy strategy;

    public Inventory() {
        // ...
    }

    public void doSomething() {
        if (strategy == null) {
            System.out.println("strategy is empty");
        } else {
            strategy.doSomething();
        }
    }

    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

}