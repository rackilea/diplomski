@Service
public myServiceClass {
   private boolean isDone = false;
   public synchronized void setIsDone(boolean isDone) {
      isDone = isDone;
   }
   public synchronized boolean getIsDone() {
      return isDone;
   }
   @Async
   public void myServiceMethod() {
      ...long-running stuff...
      setIsDone(true);
   }