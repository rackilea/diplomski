public class Matcher {

    private final Supplier<? extends MatcherThread> threadSupplier;

    public Matcher(Supplier<? extends MatcherThread> threadSupplier) {
        this.threadSupplier = threadSupplier;
    }

     protected List<Integer> runAll(List<String> clusters, int nthreads) {

        // …
        MatcherThread task = threadSupplier.get();
        task.setSubcluster(subcluster); // refactor to allow setter injection
        tasks.add(task);
        // …

    }

}