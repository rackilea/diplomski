Future<?> f = executor.submit(task);
try {
    f.get();
} catch (ExecutionException e) {
    System.out.println("task threw exception: " + e.getCause().getMessage());
}