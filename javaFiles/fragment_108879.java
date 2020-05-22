public Future<?> submit(Runnable task) {
    if (task == null) throw new NullPointerException();
    RunnableFuture<Object> ftask = newTaskFor(task, null);
    execute(ftask);
    return ftask;
}