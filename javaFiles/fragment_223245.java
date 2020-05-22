// Java
public class Outer {
    public Supplier<String> inner(final String string) {
        return new Supplier<String>() {
            @Override public Outer get() {
                return string;
            }
        }
    }
}
new Outer().inner("").get();