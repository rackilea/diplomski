public class Example {

    static class A<T> {}

    static class B<L extends A<?>> {

        void bar(L l) {
            foo((A<?>) l);
        }
    }

    static <T, L extends A<T>> void foo(L l) {
        // You can refer to both L and T here
    }
}