// Java
public class Outer {
    public class Inner implements Supplier<Outer> {
        @Override public Outer get() {
            return Outer.this;
        }
    }
}
new Outer().new Inner().get();