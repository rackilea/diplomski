try {
    final Double sum = future.get();
    result.add(sum);
} catch (InterruptedException | ExecutionException e) {
    throw new RuntimeException(e);
}