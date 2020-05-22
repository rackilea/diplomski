public class FooReader {
    public String ReadFoo(Foo foo) {
        // This returns the Foo **property**
        return foo.FooName;
    }

    public String ReadBar(Foo foo) {
        // This returns the Bar **field**
        return foo.BarName;
    }
}