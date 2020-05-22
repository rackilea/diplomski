public class MyFactory {
    public static <T> MyBase create(Class<T> _c) {
        return ( _c == Derived1.class ) ? createNewDerived1() : null;
    }
}

// caller
MyFactory.create(Derived1.class);