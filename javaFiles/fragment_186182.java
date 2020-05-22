public static void main(String[] args) throws Throwable {
    ReferenceQueue<Object> discovered = new ReferenceQueue<>();
    Set<WeakReference<?>> holder = new HashSet<>();

    CompletableFuture<Object> initial = CompletableFuture.completedFuture("somevalue");

    CompletableFuture<Object> finalStage = initial.thenCompose(value -> {
        CompletableFuture<Object> lost = new CompletableFuture<>();
        holder.add(new WeakReference<>(lost, discovered));
        return lost;
    });
    waitFor(finalStage, holder, discovered);
    finalStage = initial.thenCompose(value -> {
        CompletableFuture<Object> saved = CompletableFuture.supplyAsync(()-> {
            LockSupport.parkNanos(TimeUnit.SECONDS.toNanos(1));
            return "newvalue";
        });
        holder.add(new WeakReference<>(saved, discovered));
        return saved;
    });
    waitFor(finalStage, holder, discovered);
}
private static void waitFor(CompletableFuture<Object> f, Set<WeakReference<?>> holder,
                    ReferenceQueue<Object> discovered) throws InterruptedException {
    while(!f.isDone() && !holder.isEmpty()) {
        System.gc();
        Reference<?> removed = discovered.remove(100);
        if(removed != null) {
            holder.remove(removed);
            System.out.println("future has been garbage collected");
        }
    }
    if(f.isDone()) {
        System.out.println("stage completed with "+f.join());
        holder.clear();
    }
}