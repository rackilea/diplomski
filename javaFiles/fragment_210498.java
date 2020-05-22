final DoubleAccumulator lowest = new DoubleAccumulator(Math::min, Double.POSITIVE_INFINITY);
/* Loop, creating all the tasks... */
for ( ... ) {
  tasks.add(Executors.callable(new Runnable() {
    public void run()
    {
      double score = 0; /* Compute a real score here. */
      lowest.accumulate(score);
    }
  }));
}
/* Invoke all the tasks, when successful... */
double lowestScore = lowest.get();