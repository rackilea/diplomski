final class TerroristPreprocessor implements Callable<PersonWrapper> {

    private final Person person;

    public TerroristPreprocessor(final Person person) {
        this.person = person;
    }

    @Override
    public PersonWrapper call() throws Exception {
        final Set<String> splitName = new HashSet<>(Arrays.asList(person.getName().split("\\s+")));
        return new PersonWrapper(person, splitName);
    }
}

final ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
final ExecutorCompletionService<PersonWrapper> cs = new ExecutorCompletionService<>(es);

for (final Person terrorist : terrorists) {
    cs.submit(new TerroristPreprocessor(terrorist));
}
final Collection<PersonWrapper> proccessedTerrorists = new LinkedList<>();
for (int i = 0; i < terrorists.size(); ++i) {
    try {
        proccessedTerrorists.add(cs.take().get());
    } catch (InterruptedException ex) {
        return;
    } catch (ExecutionException ex) {
        throw new RuntimeException(ex);
    }
}

final class ProblemClientFinder implements Runnable {

    private final Person client;
    private final Collection<ProblemClient> results;

    public ProblemClientFinder(final Person client, final Collection<ProblemClient> results) {
        this.client = client;
        this.results = results;
    }

    @Override
    public void run() {
        final Collection<String> splitName = Arrays.asList(client.getName().split("\\s+"));
        for (final PersonWrapper terrorist : proccessedTerrorists) {
            if (terrorist.getProcessedName().containsAll(splitName)) {
                results.add(new ProblemClient(client, terrorist.getPerson()));
            }
        }
    }
}

final Collection<ProblemClient> results = new ConcurrentLinkedQueue<>();
final Collection<Future<?>> futures = new LinkedList<>();
for (final Person client : clients) {
    futures.add(es.submit(new ProblemClientFinder(client, results)));
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
//process results
for (final ProblemClient problemClient : results) {
    //whatever.
}