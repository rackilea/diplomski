// Java
public class Outer {
    String string = "";
    public class Inner implements Supplier<String> {
        @Override public String get() {
            return string;
        }
    }
}
new Outer().new Inner().get();