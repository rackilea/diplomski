public class Worker implements Runnable {

    private final Map<Integer, Section> sections;
    private final BlockingQueue<SubProblem> problemQ = new ArrayBlockingQueue<SubProblem>(4096);
    private final int batchSize;

    public Worker(final Map<Integer, Section> sectionsIHave, final int batchSize) {
        this.sections = sectionsIHave;
        this.batchSize = batchSize;
    }

    public Set<Integer> getSectionIds() {
        return sections.keySet();
    }

    public void execute(final SubProblem command) throws InterruptedException {

        if (sections.containsKey(command.getSectionId())) {
            problemQ.put(command);
        } else {
            throw new IllegalArgumentException("Invalid section id for worker: " + command.getSectionId());
        }

    }

    @Override
    public void run() {
        final List<SubProblem> batch = new ArrayList<SubProblem>(batchSize);
        while (!Thread.interrupted()) {
            batch.clear();

            try {
                batch.add(problemQ.take());
                for (int i = 1; i < batchSize; i++) {
                    final SubProblem problem = problemQ.poll();
                    if (problem != null) {
                        batch.add(problem);
                    } else {
                        break;
                    }

                    process(batch);
                }
            } catch (final InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

    private void process(final List<SubProblem> batch) {
        // Submit to remote process.
    }

    private static Map<Integer, Worker> indexWorkers(final List<Worker> workers) {
        final Map<Integer, Worker> temp = new HashMap<Integer, Worker>();
        for (final Worker worker : workers) {
            for (final Integer sectionId : worker.getSectionIds()) {
                temp.put(sectionId, worker);
            }
        }
        return Collections.unmodifiableMap(temp);
    }

    public static void main(final String[] args) throws InterruptedException {
     // Load workers, where worker is bound to single remote service
        final List<Worker> workers = getWorkers();
        final Map<Integer, Worker> workerReverseIndex = indexWorkers(workers);
        final List<SubProblem> subProblems = getSubProblems();
        for (final SubProblem problem : subProblems) {
            final Worker w = workerReverseIndex.get(problem.getSectionId());
            w.execute(problem);
        }
    }
}