public class Foo {
    public static final boolean LOADED;
    static {
        Native.register("foo");
        LOADED = true;
    }
    public static native void call_foo();
}

public class Bar {
    static {
        // Reference "Foo" so that it is loaded first
        if (Foo.LOADED) {
            System.loadLibrary("baz");
            // Or System.load("/path/to/libbaz.so")
            Native.register("bar");
        }
    }
    public static native void call_bar();
}