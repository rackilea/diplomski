final Collection<Indexer> tasks = new ArrayList<Indexer>();
for(final File f: main.queue) {
    tasks.add(new Indexer(main.writer, main.identificatore, f));
}

final ExecutorService es = Executors.newFixedThreadPool(4);
final List<Future<Object>> results = es.invokeAll(tasks);