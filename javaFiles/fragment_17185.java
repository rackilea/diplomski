public class Outer$1 implements Inner {

    private final Outer outer; // synthetic reference to enclosing instance

    public Outer$1(Outer outer) {
        this.outer = outer;
    }

    public void innerAction() {
        // the method outside of scope is called through the reference to Outer
        outer.methodInOuter();
    }
}