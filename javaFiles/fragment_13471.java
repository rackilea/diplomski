public class FireAction implements Action {
    public static final String NAME = "FIRE_ACTION";

    @Override
    public void execute() {
        System.out.println("Fire key pressed!");
    }

    @Override
    public String toString() {
        return NAME;
    }

}