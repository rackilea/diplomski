class RandomRunner {
    List<Runnable> runnables = new ArrayList<>();
    public void add(int value, Runnable toRun) {
        // add the methods as often as their weight indicates.
        // this should be fine for smaller numbers;
        // if you get lists with millions of entries, optimize
        for (int i = 0; i < value; i++) {
            runnables.add(toRun);
        }
    }
    public void remove(Runnable r) {
        Iterator<Runnable> myRunnables = runnables.iterator();
        while (myRunnables.hasNext()) {
            if (myRunnables.next() == r) {
                myRunnables.remove();
            }
    }
    public void runRandomly() {
        if (runnables.isEmpty()) return;
        // roll n-sided die
        int runIndex = ThreadLocalRandom.current().nextInt(0, runnables.size());
        runnables.get(runIndex).run();
    }
}