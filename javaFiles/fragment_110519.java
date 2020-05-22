public class Box<MyType> {
    private MyType t;

    public void set(MyType t) { this.t = t; }
    public MyType get() { return t; }
}