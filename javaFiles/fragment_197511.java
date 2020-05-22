public Future<String> submitPair(ExecutorService executorService) throws InterruptedException {
    ExecutorCompletionService<String> ecs = new ExecutorCompletionService<>(executorService);
    ecs.submit(() -> oneWay());
    ecs.submit(() -> orAnother());
    return ecs.take();
}