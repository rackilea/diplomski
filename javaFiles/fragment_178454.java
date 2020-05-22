final double avg = solver.getAverage();
final double best = solver.getCurrentBest().getFitness();
Platform.runLater(new Runnable() {
    @Override
    public void run() {
        addData(avg, best);
    }
});