public abstract class Foo implements Cloneable {

    private int a;
    private String b;

    public Foo(int a, String b) {
        this.a = a;
        this.b = b;
    } 

    public abstract void run();

    public int getA() { return a; }

    public String getB() { return b; }

    @Override
    public final Foo clone() {
        try {
            return (Foo) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Can't happen
        }
    }
}