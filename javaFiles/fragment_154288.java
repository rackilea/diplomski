public class test {
    public static <T extends Number> void foo(Class<T> c, T x) {
        ;
    }

    @SuppressWarnings("unchecked")
    public static <T> Class<? extends T> getClass2(T x) {
        return((Class<? extends T>)x.getClass());
    }

    public static void bar(int x) {
        foo(Integer.class, x);
    }

    public static void baz(Number x) {
        foo(getClass2(x), x);
    }
}