IntUnaryOperator Y(Function<IntUnaryOperator, IntUnaryOperator> f) {
    return g((G)g -> f.apply(x -> g.apply(g).applyAsInt(x)));
}

// renamed the type parameter from G to F to avoid confusion
<F extends Function<F, IntUnaryOperator>> IntUnaryOperator g(F f) {
    return f.apply(f);
}

// can't get rid of this interface
interface G extends Function<G, IntUnaryOperator> {/**/}