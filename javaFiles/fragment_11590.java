public static ComposeStart compose() {
    return new ComposeStart();
}

class ComposeStart {
    public <B,C> ComposeContinuation<B,C> ap(Fn<B,C> f) {
        return new ComposeContinuation<B, C>(f);
    }
}

class ComposeContinuation<B, C> {
    private final Fn<B,C> f;

    ComposeContinuation(Fn<B,C> f) {
        this.f = f;
    }

    public <A> Fn<A,C> ap(final Fn<A,B> g) {
        return new Fn<A,C>() {
            public C ap(A a) {
                return f.ap(g.ap(a));
            }
        };
    }
}