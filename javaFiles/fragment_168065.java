/**
 * Builds map of anagrams
 */
private void buildAnagramMap() {
    System.out.println("Starting build anagrams map at thread " + Thread.currentThread().getName());
    if (glossary != null) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < availableProcessors.get(); i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    end.set(start.get() + glossary.size() / availableProcessors.get());
                    int startAt = start.get();
                    start.set(end.get() + 1);
                    // if not divisible by number of available processors then we add residue to last thread
                    if ((glossary.size() % availableProcessors.get() > 0) &&
                            ((glossary.size() - end.get()) < (glossary.size() / availableProcessors.get()))) {
                        end.set(glossary.size());
                    }
                    for (int i = startAt; i < end.get(); i++) {
                        String key = sortString(glossary.get(i));
                        HashSet<String> val = anagrams.get(key);
                        if (val == null) {
                            val = new HashSet<>();
                            anagrams.put(key, val);
                        }
                        val.add(glossary.get(i));
                    }
                }
            });
        }
        executorService.shutdown();
        while (!executorService.isTerminated()) {
            try {
                executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } else {
        System.err.println("Glossary doesn't exist");
    }
}
/**
 * Splits glossary on fragments to search
 * @return point to start
 */
private synchronized int fragmentation() {
    end.set(start.get() + glossary.size() / availableProcessors.get());
    int startAt = start.get();
    start.set(end.get() + 1);
    return startAt;
}