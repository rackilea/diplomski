public class BaseClass {

    private final UI ui = ... ;

    private void doMove() {
        // implementation here...
    }

    public void move() {
        ui.getOperationQueue().add(this::doMove);
    }

    private void doTakeHoney() {
        // implementation here...
    }

    public void takeHoney() {
        ui.getOperationQueue().add(this::doTakeHoney);
    }
}