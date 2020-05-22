public class SomeObject {
    private final SomeObjects parent;

    public SomeObject(SomeObjects parent) {
        this.parent = parent;
    }

    public State getState() {
        return parent.state; // Ideally accessed via method too
    }
}