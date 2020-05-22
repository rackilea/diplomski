interface Iface<T> {
    void accept(T a);
}

class Impl2 implements Iface<String> {
    public void accept(String a) { }
}

class TestCase {
    static Class<? extends Iface> clazz = Impl2.class;

    public static void main(String[] args) throws Exception {
        // throws ClassCastException
        clazz.newInstance().accept(new Object());
    }
}