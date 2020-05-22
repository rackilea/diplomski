@Override
public final CompletionStage<Integer> executeAsync(Executor executor) {
    return ExecutorProviderCompletionStage.of(
        CompletableFuture.supplyAsync(blocking(this::execute), executor), () -> executor
    );
}