public static class FunctionRef<A, B> {
    private F<A, B> func;
    public void set(F<A, B> f) { func = f; }
    public F<A, B> get() { return func; }
}

public static class Pair<A, B> {
    public final A first; public final B second;
    public Pair(A a, B b) {
        this.first = a; this.second = b;
    }
}

public static <A, B> F<A, B> memoFix(final F<Pair<FunctionRef<A, B>, A>, B> func) {
    final FunctionRef<A, B> y = new FunctionRef<A, B>();
    y.set(
        memoize(new F<A, B>() {
            @Override
            public B f(A a) {
                return func.f(new Pair<FunctionRef<A, B>, A>(y, a));
            }
        })
    );
    return y.get();
}


//Test that it works
public static void main(String[] args) {
    F<Pair<FunctionRef<Integer, Integer>,Integer>, Integer> fib = new F<Pair<FunctionRef<Integer, Integer>,Integer>, Integer>() {
        @Override
        public Integer f(Pair<FunctionRef<Integer, Integer>, Integer> a) {
            int value = a.second;
            System.out.println("computing fib of " + value);
            if (value == 0) return 0;
            if (value == 1) return 1;
            return a.first.get().f(value - 2) + a.first.get().f(value - 1);
        }
    };

    F<Integer, Integer> memoized = memoFix(fib);
    System.out.println(memoized.f(10));
}