ScheduledExecutorService ex = Executors.newSingleThreadScheduledExecutor();
ex.schedule(new Updater(), 1, TimeUnit.MILLISECONDS);
...
class Updater extends Runnable {
    @Override
    public void run() {
      // invoke the EDT via Swing Utilities here.     
    }
}