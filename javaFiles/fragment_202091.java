static class Search implements Callable<Set<String>> {
    private final File file;
    private final Set<String> toFind;
    private final long lastModified;

    public Search(File file, Set<String> toSearchFor) {
        this.file = file;
        lastModified = file.lastModified();
        toFind = new CopyOnWriteArraySet<>(toSearchFor);
    }

    @Override
    public Set<String> call() throws Exception {
        Set<String> found = new HashSet<>();
        Scanner in = new Scanner(new FileReader(file));
        while (in.hasNextLine() && !toFind.isEmpty()) {
            String line = in.nextLine();
            for (String s : toFind) {
                if (line.contains(s)) {
                    toFind.remove(s);
                    found.add(s);
                }
            }
        }
        in.close();

        if (file.lastModified() != lastModified) 
            throw new AssertionError(file + " was modified");
        return found;
    }
}

public static Map<String, AtomicInteger> performSearches(
        ExecutorService service, File[] files, Set<String> toFind)
        throws ExecutionException, InterruptedException {
    List<Future<Set<String>>> futures = new ArrayList<>();
    for (File file : files) {
        futures.add(service.submit(new Search(file, toFind)));
    }
    Map<String, AtomicInteger> counts = new LinkedHashMap<>();
    for (String s : toFind)
        counts.put(s, new AtomicInteger());
    for (Future<Set<String>> future : futures) {
        for (String s : future.get())
            counts.get(s).incrementAndGet();
    }
    return counts;
}