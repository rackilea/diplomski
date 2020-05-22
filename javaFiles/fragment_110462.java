public abstract class Base {
    public boolean m1() {
        // validation stuff
    }
    public final void m2() {
        if (m1()) {
            m2Imp();
        }
    }
    protected abstract void m2Imp();
}