public final class Stage<T,R> {
    static final Runnable NO_OP = () -> {};
    public static <I,O> Stage<I,O> create(Function<I,O> f) {
        return new Stage<>(f, NO_OP);
    }
    public static <I,O> Stage<I,O> create(Function<I,O> f, Runnable cleanup) {
        return new Stage<>(f, cleanup);
    }
    private final Function<T,R> actualAction;
    private final Runnable cleanup;

    private Stage(Function<T,R> f, Runnable r) {
        actualAction=f;
        cleanup=r;
    }

    public <P> Stage<T,P> nextStage(Function<R,P> nextStage) {
        return new Stage<>(actualAction.andThen(nextStage), cleanup);
    }
    public <P> Stage<T,P> nextStage(Function<R,P> nextStage, Runnable nextCleanup) {
        return new Stage<>(actualAction.andThen(nextStage),
            cleanup==NO_OP? nextCleanup: () -> { cleanup.run(); nextCleanup.run(); });
    }
    public R process(T t) {
        return actualAction.apply(t);
    }
    public Function<T, R> getActualAction() {
        return actualAction;
    }
    public void cleanup() {
        cleanup.run();
    }
    public Runnable getCleanup() {
        return cleanup;
    }
}