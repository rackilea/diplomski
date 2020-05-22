public interface Foo extends Library {
    Foo INSTANCE = (Foo)Native.loadLibrary("foo");
}
public interface Bar extends Library {
    // Reference Foo prior to instantiating Bar, just be sure
    // to reference the Foo class prior to creating the Bar instance
    Foo FOO = Foo.INSTANCE;
    Bar INSTANCE = (Bar)Native.loadLibrary("bar");
}