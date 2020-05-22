IntUnaryOperator fact = Y(rec -> n -> n == 0 ? 1 : n * rec.applyAsInt(n - 1));

IntUnaryOperator Y(Function<IntUnaryOperator, IntUnaryOperator> f) {
    return this.<G>g(g -> f.apply(x -> g.apply(g).applyAsInt(x)));
}

// renamed the type parameter from G to F to avoid confusion
<F extends Function<F, IntUnaryOperator>> IntUnaryOperator g(F f) {
    return f.apply(f);
}

// can't get rid of this interface
interface G extends Function<G, IntUnaryOperator> {/**/}