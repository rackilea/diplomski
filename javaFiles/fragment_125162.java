class RandomRunner {
    private List<Integer, Runnable> runnables = new ArrayList<>();
    public void add(int value, Runnable toRun) {
        runnables.add(new Pair<>(value, toRun));
    }
    public void remove(Runnable toRemove) {
        for (Iterator<Pair<Integer, Runnable>> r = runnables.iterator();
            r.hasNext(); ) {
            if (toRemove == r.next().second) {
               r.remove();
               break;
            }
        }
    }
    public void runRandomly() {
        // split list, use code from above
    }
}