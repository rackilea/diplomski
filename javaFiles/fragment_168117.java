ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
boolean running;

public void setup() {
   scheduler.scheduleAtFixedRate(runner(), 0, 5, TimeUnit.MILLISECONDS);

}

private Runnable runner() {
  return () -> {

    while (running) {
       try {
        //DO YOUR STUFF HERE
        System.err.println("RUNNING");
        Thread.sleep(500);
      } catch (InterruptedException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
   }
 };
}

public void go() {
  running = true;
}

public void stop() {
 running = false ;
}

public void shutdown() {
  scheduler.shutdownNow();
}


public static void main(String[] args) throws InterruptedException {
  Demo tasks = new Demo();
  tasks.setup();
  for (int i = 1; i <= 5; i++) {
    System.err.println("GO FOR IT " + i);
    tasks.go();
    Thread.sleep(2000);
    tasks.stop();
    Thread.sleep(1000);
  }
  tasks.shutdown();
}