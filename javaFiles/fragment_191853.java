class TaskRunner {
   private int noOfThreads;  //The no of threads which you want to run always
   private boolean started;
   private int taskQueueSize; //No. of tasks that can be in queue at a time, when try to add more tasks, then you have to wait.
   private BlockingQueue<Runnable> taskQueue;
   private List<Worker> workerThreads;

   public TaskRunner(int noOfThreads, int taskQueueSize) {
      this.noOfThreads = noOfThreads;
      this.taskQueueSize = taskQueueSize;
   }

  //You can pass any type of task(provided they are implementing Runnable)
   public void submitTask(Runnable task) {
      if(!started) {
         init();
      }
      try {
         taskQueue.put(task);
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   public void shutdown() {
      for(Worker worker : workerThreads){
         worker.stopped = true;
      }
   }

   private void init() {
      this.taskQueue = new LinkedBlockingDeque<>(taskQueueSize);
      this.workerThreads = new ArrayList<>(noOfThreads);
      for(int i=0; i< noOfThreads; i++) {
         Worker worker = new Worker();
         workerThreads.add(worker);
         worker.start();
      }
   }

   private class Worker extends Thread {
      private volatile boolean stopped;
      public void run() {
         if(!stopped) {
            try {
               taskQueue.take().run();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
         }
      }
   }
}

class Task1 implements Runnable {
   @Override
   public void run() {
      //Your implementation for the task of type 1
   }
}

class Task2 implements Runnable {
   @Override
   public void run() {
      //Your implementation for the task of type 2
   }
}

class Main {

   public static void main(String[] args) {
      TaskRunner runner = new TaskRunner(3,5);
      runner.submitTask(new Task1());
      runner.submitTask(new Task2());
      runner.shutdown();
   }
}