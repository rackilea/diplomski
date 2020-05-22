abstract <T> void f(Supplier<T> s);

abstract <T, X extends Throwable> T g(Supplier<? extends X> x) throws X;

void bug() {
    f(() -> g(() -> new RuntimeException("foo")));
}