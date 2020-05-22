final class NameProcessor implements Callable<PersonWrapper> {

    private final Person person;

    public NameProcessor(final Person person) {
        this.person = person;
    }

    @Override
    public PersonWrapper call() throws Exception {
        return new PersonWrapper(person, Arrays.asList(person.getName().split("\\s+")));
    }
}

final ExecutorService es = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
final ExecutorCompletionService<PersonWrapper> cs = new ExecutorCompletionService<>(es);

for (final Person client : clients) {
    cs.submit(new NameProcessor(client));
}
final Collection<PersonWrapper> proccessedClients = new LinkedList<>();
for (int i = 0; i < clients.size(); ++i) {
    try {
        proccessedClients.add(cs.take().get());
    } catch (InterruptedException ex) {
        return;
    } catch (ExecutionException ex) {
        throw new RuntimeException(ex);
    }
}

final class TerroristProcessor implements Runnable {

    private final Person person;
    private final Collection<ProblemClient> results;

    public TerroristProcessor(final Person person, final Collection<ProblemClient> results) {
        this.person = person;
        this.results = results;
    }

    @Override
    public void run() {
        final Set<String> splitName = new HashSet<>(Arrays.asList(person.getName().split("\\s+")));
        for (final PersonWrapper client : proccessedClients) {
            if (splitName.containsAll(client.getProcessedName())) {
                results.add(new ProblemClient(client.getPerson(), person));
            }
        }
    }
}

final Collection<ProblemClient> results = new ConcurrentLinkedQueue<>();
final Collection<Future<?>> futures = new LinkedList<>();
for (final Person terrorist : terrorists) {
    futures.add(es.submit(new TerroristProcessor(terrorist, results)));
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