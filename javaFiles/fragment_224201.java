class HandlePriorityInversionTask extends FutureTask<ResultType>
{
   Integer priority;  // non null if set
   Integer originalPriority;
   Thread thread;
   public ResultType get() {
      if (!isDone()) 
         setPriority(Thread.currentThread().getPriority());
      return super.get();
   }
   public void run() {
      synchronized (this) {
         thread = Thread.currentThread();
         originalPriority = thread.getPriority();
         if (priority!=null) setPriority(priority);
      } 
      super.run();
   }
   protected synchronized void done() {
         if (originalPriority!=null) setPriority(originalPriority);
         thread = null;
   }

   void synchronized setPriority(int priority) {
       this.priority = Integer.valueOf(priority);
       if (thread!=null)
          thread.setPriority(priority);
   }
}