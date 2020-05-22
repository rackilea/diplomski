public class ThreadFun {

  public static void main(String[] args) {
    MyTask task = new MyTask();
    Thread thread = new Thread(task);
    thread.start();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
    }
    task.pauseTask();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
    }
    task.resumeTask();
    try {
      Thread.sleep(1000);
    } catch (InterruptedException ex) {
    }
    task.stopTask();
  }

  public enum TaskState {

    Running,
    Stopped,
    Paused

  }

  public static class MyTask implements Runnable {

    private static final Object PAUSED_LOCK = new Object();

    private volatile TaskState state = TaskState.Running;

    public void pauseTask() {
      if (state == TaskState.Running) {
        System.out.println("Paused...");
        state = TaskState.Paused;
      }
    }

    public void resumeTask() {
      if (state == TaskState.Paused) {
        state = TaskState.Running;
        synchronized (PAUSED_LOCK) {
          PAUSED_LOCK.notifyAll();
        }
        System.out.println("Resumed...");
      }
    }

    public void stopTask() {
      if (state == TaskState.Running || state == TaskState.Paused) {
        state = TaskState.Stopped;
        System.out.println("Stopped...");
      }
    }

    public boolean isStopped() {
      return state == TaskState.Stopped;
    }

    public boolean isPaused() {
      return state == TaskState.Paused;
    }

    protected void doPause() {
      synchronized (PAUSED_LOCK) {
        while (isPaused()) {
          try {
            PAUSED_LOCK.wait();
          } catch (InterruptedException ex) {
          }
        }
      }
    }

    @Override
    public void run() {

      int index = 0;
      while (!isStopped() && index < 1000) {
        try {
          Thread.sleep(25);
        } catch (InterruptedException ex) {
        }
        doPause();
        index++;
        System.out.println(index);
      }
      stopTask(); // Make sure the task is marked as begin stopped ;)

    }

  }
}