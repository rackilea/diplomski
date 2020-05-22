public class Foo {
    public interface Bar {
        void callback();
    }
    public static void registerCallback(Bar bar) {...}
}
// ...elsewhere...
Foo.registerCallback(new Foo.Bar() {
    public void callback() {...}
});