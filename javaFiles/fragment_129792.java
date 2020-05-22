abstract <T> void f(T t);

abstract <T, X extends Throwable> T g(X x) throws X;

void bug() {
    f(g(new RuntimeException("foo")));
}