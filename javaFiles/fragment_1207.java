/**
 * A {@link CompletableFuture} that eases debugging.
 *
 * @param <T> the type of value returned by the future
 */
public final class DebugCompletableFuture<T> extends CompletableFuture<T>
{
    private static RunMode RUN_MODE = RunMode.DEBUG;
    private static final Set<String> CLASS_PREFIXES_TO_REMOVE = ImmutableSet.of(DebugCompletableFuture.class.getName(),
        CompletableFuture.class.getName(), ThreadPoolExecutor.class.getName());
    private static final Set<Class<? extends Throwable>> EXCEPTIONS_TO_UNWRAP = ImmutableSet.of(AsynchronousException.class,
        CompletionException.class, ExecutionException.class);
    private final CompletableFuture<T> delegate;
    private final AsynchronousException asyncStacktrace;

    /**
     * @param delegate the stage to delegate to
     * @throws NullPointerException if any of the arguments are null
     */
    private DebugCompletableFuture(CompletableFuture<T> delegate)
    {
        requireThat("delegate", delegate).isNotNull();
        this.delegate = delegate;
        this.asyncStacktrace = new AsynchronousException();
        delegate.whenComplete((value, exception) ->
        {
            if (exception == null)
            {
                super.complete(value);
                return;
            }
            exception = Exceptions.unwrap(exception, EXCEPTIONS_TO_UNWRAP);
            asyncStacktrace.initCause(exception);
            filterStacktrace(asyncStacktrace, element ->
            {
                String className = element.getClassName();
                for (String prefix : CLASS_PREFIXES_TO_REMOVE)
                    if (className.startsWith(prefix))
                        return true;
                return false;
            });
            Set<String> newMethods = getMethodsInStacktrace(asyncStacktrace);
            if (!newMethods.isEmpty())
            {
                Set<String> oldMethods = getMethodsInStacktrace(exception);
                newMethods.removeAll(oldMethods);
                if (!newMethods.isEmpty())
                {
                    // The async stacktrace introduces something new
                    super.completeExceptionally(asyncStacktrace);
                    return;
                }
            }
            super.completeExceptionally(exception);
        });
    }

    /**
     * @param exception an exception
     * @return the methods referenced by the stacktrace
     * @throws NullPointerException if {@code exception} is null
     */
    private Set<String> getMethodsInStacktrace(Throwable exception)
    {
        requireThat("exception", exception).isNotNull();
        Set<String> result = new HashSet<>();
        for (StackTraceElement element : exception.getStackTrace())
            result.add(element.getClassName() + "." + element.getMethodName());
        for (Throwable suppressed : exception.getSuppressed())
            result.addAll(getMethodsInStacktrace(suppressed));
        return result;
    }

    /**
     * @param <T2>     the type returned by the delegate
     * @param delegate the stage to delegate to
     * @return if {@code RUN_MODE == DEBUG} returns an instance that wraps {@code delegate}; otherwise, returns {@code delegate}
     * unchanged
     * @throws NullPointerException if any of the arguments are null
     */
    public static <T2> CompletableFuture<T2> wrap(CompletableFuture<T2> delegate)
    {
        if (RUN_MODE != RunMode.DEBUG)
            return delegate;
        return new DebugCompletableFuture<>(delegate);
    }

    /**
     * Removes stack trace elements that match a filter. The exception and its descendants are processed recursively.
     * <p>
     * This method can be used to remove lines that hold little value for the end user (such as the implementation of utility functions).
     *
     * @param exception     the exception to process
     * @param elementFilter returns true if the current stack trace element should be removed
     */
    private void filterStacktrace(Throwable exception, Predicate<StackTraceElement> elementFilter)
    {
        Throwable cause = exception.getCause();
        if (cause != null)
            filterStacktrace(cause, elementFilter);
        for (Throwable suppressed : exception.getSuppressed())
            filterStacktrace(suppressed, elementFilter);
        StackTraceElement[] elements = exception.getStackTrace();
        List<StackTraceElement> keep = new ArrayList<>(elements.length);
        for (StackTraceElement element : elements)
        {
            if (!elementFilter.test(element))
                keep.add(element);
        }
        exception.setStackTrace(keep.toArray(new StackTraceElement[0]));
    }

    @Override
    public <U> CompletableFuture<U> thenApply(Function<? super T, ? extends U> fn)
    {
        return wrap(super.thenApply(fn));
    }

    @Override
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn)
    {
        return wrap(super.thenApplyAsync(fn));
    }

    @Override
    public <U> CompletableFuture<U> thenApplyAsync(Function<? super T, ? extends U> fn, Executor executor)
    {
        return wrap(super.thenApplyAsync(fn, executor));
    }

    @Override
    public CompletableFuture<Void> thenAccept(Consumer<? super T> action)
    {
        return wrap(super.thenAccept(action));
    }

    @Override
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action)
    {
        return wrap(super.thenAcceptAsync(action));
    }

    @Override
    public CompletableFuture<Void> thenAcceptAsync(Consumer<? super T> action, Executor executor)
    {
        return wrap(super.thenAcceptAsync(action, executor));
    }

    @Override
    public CompletableFuture<Void> thenRun(Runnable action)
    {
        return wrap(super.thenRun(action));
    }

    @Override
    public CompletableFuture<Void> thenRunAsync(Runnable action)
    {
        return wrap(super.thenRunAsync(action));
    }

    @Override
    public CompletableFuture<Void> thenRunAsync(Runnable action, Executor executor)
    {
        return wrap(super.thenRunAsync(action, executor));
    }

    @Override
    public <U, V> CompletableFuture<V> thenCombine(CompletionStage<? extends U> other,
                                                   BiFunction<? super T, ? super U, ? extends V> fn)
    {
        return wrap(super.thenCombine(other, fn));
    }

    @Override
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> other,
                                                        BiFunction<? super T, ? super U, ? extends V> fn)
    {
        return wrap(super.thenCombineAsync(other, fn));
    }

    @Override
    public <U, V> CompletableFuture<V> thenCombineAsync(CompletionStage<? extends U> other,
                                                        BiFunction<? super T, ? super U, ? extends V> fn,
                                                        Executor executor)
    {
        return wrap(super.thenCombineAsync(other, fn, executor));
    }

    @Override
    public <U> CompletableFuture<Void> thenAcceptBoth(CompletionStage<? extends U> other,
                                                      BiConsumer<? super T, ? super U> action)
    {
        return wrap(super.thenAcceptBoth(other, action));
    }

    @Override
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,
                                                           BiConsumer<? super T, ? super U> action)
    {
        return wrap(super.thenAcceptBothAsync(other, action));
    }

    @Override
    public <U> CompletableFuture<Void> thenAcceptBothAsync(CompletionStage<? extends U> other,
                                                           BiConsumer<? super T, ? super U> action,
                                                           Executor executor)
    {
        return wrap(super.thenAcceptBothAsync(other, action, executor));
    }

    @Override
    public CompletableFuture<Void> runAfterBoth(CompletionStage<?> other, Runnable action)
    {
        return wrap(super.runAfterBoth(other, action));
    }

    @Override
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action)
    {
        return wrap(super.runAfterBothAsync(other, action));
    }

    @Override
    public CompletableFuture<Void> runAfterBothAsync(CompletionStage<?> other, Runnable action, Executor executor)
    {
        return wrap(super.runAfterBothAsync(other, action, executor));
    }

    @Override
    public <U> CompletableFuture<U> applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn)
    {
        return wrap(super.applyToEither(other, fn));
    }

    @Override
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn)
    {
        return wrap(super.applyToEitherAsync(other, fn));
    }

    @Override
    public <U> CompletableFuture<U> applyToEitherAsync(CompletionStage<? extends T> other, Function<? super T, U> fn,
                                                       Executor executor)
    {
        return wrap(super.applyToEitherAsync(other, fn, executor));
    }

    @Override
    public CompletableFuture<Void> acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)
    {
        return wrap(super.acceptEither(other, action));
    }

    @Override
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action)
    {
        return wrap(super.acceptEitherAsync(other, action));
    }

    @Override
    public CompletableFuture<Void> acceptEitherAsync(CompletionStage<? extends T> other, Consumer<? super T> action,
                                                     Executor executor)
    {
        return wrap(super.acceptEitherAsync(other, action, executor));
    }

    @Override
    public CompletableFuture<Void> runAfterEither(CompletionStage<?> other, Runnable action)
    {
        return wrap(super.runAfterEither(other, action));
    }

    @Override
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action)
    {
        return wrap(super.runAfterEitherAsync(other, action));
    }

    @Override
    public CompletableFuture<Void> runAfterEitherAsync(CompletionStage<?> other, Runnable action, Executor executor)
    {
        return wrap(super.runAfterEitherAsync(other, action, executor));
    }

    @Override
    public <U> CompletableFuture<U> thenCompose(Function<? super T, ? extends CompletionStage<U>> fn)
    {
        return wrap(super.thenCompose(fn));
    }

    @Override
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn)
    {
        return wrap(super.thenComposeAsync(fn));
    }

    @Override
    public <U> CompletableFuture<U> thenComposeAsync(Function<? super T, ? extends CompletionStage<U>> fn,
                                                     Executor executor)
    {
        return wrap(super.thenComposeAsync(fn, executor));
    }

    @Override
    public CompletableFuture<T> exceptionally(Function<Throwable, ? extends T> fn)
    {
        return wrap(super.exceptionally(fn));
    }

    @Override
    public CompletableFuture<T> whenComplete(BiConsumer<? super T, ? super Throwable> action)
    {
        return wrap(super.whenComplete(action));
    }

    @Override
    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action)
    {
        return wrap(super.whenCompleteAsync(action));
    }

    @Override
    public CompletableFuture<T> whenCompleteAsync(BiConsumer<? super T, ? super Throwable> action,
                                                  Executor executor)
    {
        return wrap(super.whenCompleteAsync(action, executor));
    }

    @Override
    public <U> CompletableFuture<U> handle(BiFunction<? super T, Throwable, ? extends U> fn)
    {
        return wrap(super.handle(fn));
    }

    @Override
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn)
    {
        return wrap(super.handleAsync(fn));
    }

    @Override
    public <U> CompletableFuture<U> handleAsync(BiFunction<? super T, Throwable, ? extends U> fn,
                                                Executor executor)
    {
        return wrap(super.handleAsync(fn, executor));
    }

    @Override
    public boolean complete(T value)
    {
        return delegate.complete(value);
    }

    @Override
    public boolean completeExceptionally(Throwable ex)
    {
        return delegate.completeExceptionally(ex);
    }
}