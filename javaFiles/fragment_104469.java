class LogEntry {
  private final String message;

  LogEntry(String msg) {
    message = msg;
  }
}

class LogProducer {
   private final BlockingQueue<LogEntry> queue;

   LogProducer(BlockingQueue<LogEntry> q) {
     queue = q;
   }

   public void log(String msg) {
      queue.put(new LogEntry(msg));
   }
 }

class LogConsumer implements Runnable {
   private final BlockingQueue<LogEntry> queue;

   LogConsumer(BlockingQueue<LogEntry> q) {
     queue = q;
   }

   public void run() {
     try {
       while(true) {
         LogEntry entry = queue.take();
         // do something with entry
       }
     } catch(InterruptedException ex) {
       // handle
     }
   }
}

class Setup {
  public static void main(String[] args) {
    BlockingQueue<LogEntry> queue = new LinkedBlockingQueue<LogEntry>();
    LogConsumer c = new LogConsumer(queue);
    new Thread(c).start();

    LogProducer p = new LogProducer(queue);
    p.log("asynch");
    p.log("logging");
  }
}