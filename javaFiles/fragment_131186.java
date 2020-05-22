Scheduler[] schedulers = new Schedulers[10];
for (int i = 0; i < 10; i++) {
  schedulers[i] = Schedulers.newSingle();
}

public Flux<T> wrapIntoSingleThread(Scheduler scheduler) {
  return this.flux.publishOn(scheduler);
}