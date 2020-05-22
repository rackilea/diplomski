try {
    final Double sum = future.get();
    result.add(sum);
} catch (ExecutionException e) {
    throw new RuntimeException(e);
} catch (InterruptedException e) {
    // log something here to indicate that the task has been interrupted.
}