public class Timer {
  private final List<Runnable> callbacks = new ArrayList<>();

  public void onTick(Runnable r) { synchronized (callbacks) { callbacks.add(r); } }

  public void start() {
    new Thread(() -> {
      try {
        while (true) {
          synchronized (callbacks) {
            callbacks.forEach(Runnable::run);
          }
          Thread.sleep(TimeUnit.SECONDS.toMillis(3));
        }
      } catch (InterruptedException e) {}
    }).start();
  }

  public static void main(String[] args) {
    final Timer t = new Timer();
    t.onTick(() -> System.out.println("Ide vrijeme, prođe rok"));
    t.onTick(() -> System.out.println("Eto vraga skok na skok"));
    t.start();
  }
}