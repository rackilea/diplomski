private static class TestCachingUpstream<T> implements Upstream<T> {
    private final String id = UUID.randomUUID().toString();

    private Upstream<? extends T> upstream;

    private final Clock clock;
    private final AtomicReference<TestCachingUpstream.Cached<? extends T>> ref = new AtomicReference<>();
    private final Function<? super ExecResult<T>, Duration> ttlFunc;

    private final AtomicBoolean pending = new AtomicBoolean();
    private final AtomicBoolean draining = new AtomicBoolean();
    private final Queue<Downstream<? super T>> waiting = PlatformDependent.newMpscQueue();

    public TestCachingUpstream(Upstream<? extends T> upstream, Function<? super ExecResult<T>, Duration> ttl) {
        this(upstream, ttl, Clock.systemUTC());
    }

    @VisibleForTesting
    TestCachingUpstream(Upstream<? extends T> upstream, Function<? super ExecResult<T>, Duration> ttl, Clock clock) {
        this.upstream = upstream;
        this.ttlFunc = ttl;
        this.clock = clock;
    }

    private void tryDrain() {
        if (draining.compareAndSet(false, true)) {
            try {
                TestCachingUpstream.Cached<? extends T> cached = ref.get();
                if (needsFetch(cached)) {
                    if (pending.compareAndSet(false, true)) {
                        Downstream<? super T> downstream = waiting.poll();

                        System.out.printf("[%s] [%s] no pending execution and downstream is %s and cached is %s...%n", id, Thread.currentThread().getName(), downstream == null ? "null" : "not null", cached);

                        if (downstream == null) {
                            pending.set(false);
                        } else {
                            try {
                                yield(downstream);
                            } catch (Throwable e) {
                                System.out.printf("[%s] [%s] calling receiveResult after catching exception %s%n", id, Thread.currentThread().getName(), e.getClass());
                                receiveResult(downstream, ExecResult.of(Result.error(e)));
                            }
                        }
                    }
                } else {
                    System.out.printf("[%s] [%s] upstream does not need fetching...%n", id, Thread.currentThread().getName());
                    Downstream<? super T> downstream = waiting.poll();
                    while (downstream != null) {
                        downstream.accept(cached.result);
                        downstream = waiting.poll();
                    }
                }
            } finally {
                draining.set(false);
            }
        }

        if (!waiting.isEmpty() && !pending.get() && needsFetch(ref.get())) {
            tryDrain();
        }
    }

    private boolean needsFetch(TestCachingUpstream.Cached<? extends T> cached) {
        return cached == null || (cached.expireAt != null && cached.expireAt.isBefore(clock.instant()));
    }

    private void yield(final Downstream<? super T> downstream) throws Exception {
        System.out.printf("[%s] [%s] calling yield... %s %n", id, Thread.currentThread().getName(), upstream == null ? "upstream is null..." : "");
        upstream.connect(new Downstream<T>() {
            public void error(Throwable throwable) {
                System.out.printf("[%s] [%s] upstream.connect.error%n", id, Thread.currentThread().getName());
                receiveResult(downstream, ExecResult.of(Result.<T>error(throwable)));
            }

            @Override
            public void success(T value) {
                System.out.printf("[%s] [%s] upstream.connect.success%n", id, Thread.currentThread().getName());
                receiveResult(downstream, ExecResult.of(Result.success(value)));
            }

            @Override
            public void complete() {
                System.out.printf("[%s] [%s] upstream.connect.complete%n", id, Thread.currentThread().getName());
                receiveResult(downstream, CompleteExecResult.get());
            }
        });
    }

    @Override
    public void connect(Downstream<? super T> downstream) throws Exception {
        TestCachingUpstream.Cached<? extends T> cached = this.ref.get();
        if (needsFetch(cached)) {
            Promise.<T>async(d -> {
                waiting.add(d);
                tryDrain();
            }).result(downstream::accept);
        } else {
            downstream.accept(cached.result);
        }
    }

    private void receiveResult(Downstream<? super T> downstream, ExecResult<T> result) {
        Duration ttl = Duration.ofSeconds(0);
        try {
            ttl = ttlFunc.apply(result);
        } catch (Throwable e) {
            if (result.isError()) {
                //noinspection ThrowableResultOfMethodCallIgnored
                result.getThrowable().addSuppressed(e);
            } else {
                result = ExecResult.of(Result.error(e));
            }
        }

        Instant expiresAt;
        if (ttl.isNegative()) {
            expiresAt = null; // eternal
            System.out.printf("[%s] [%s] releasing upstream... (%s) %n", id, Thread.currentThread().getName(), result.toString());
            upstream = null; // release
        } else if (ttl.isZero()) {
            expiresAt = clock.instant().minus(Duration.ofSeconds(1));
        } else {
            expiresAt = clock.instant().plus(ttl);
        }

        ref.set(new TestCachingUpstream.Cached<>(result, expiresAt));
        pending.set(false);

        downstream.accept(result);

        tryDrain();
    }

    static class Cached<T> {
        final ExecResult<T> result;
        final Instant expireAt;

        Cached(ExecResult<T> result, Instant expireAt) {
            this.result = result;
            this.expireAt = expireAt;
        }
    }
}