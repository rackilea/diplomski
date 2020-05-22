final Collection<Future<?>> futures = new LinkedList<>();
for (final String terrorist : terrorists) {
    futures.add(es.submit(new TerroristProcessor(terrorist)));
}
es.shutdown();
es.awaitTermination(1, TimeUnit.DAYS);
for (final Future<?> f : futures) {
    try {
        f.get();
    } catch (ExecutionException ex) {
        throw new RuntimeException(ex);
    }
}