public class LiveKPIUpdates extends Thread {
  private static final int MAX_QUEUE_SIZE = 1000;
  private static LinkedList < UpdateLine > highQueue = new LinkedList < UpdateLine > ();
  private static LinkedList < UpdateLine > lowQueue = new LinkedList < UpdateLine > ();
  private static UpdateThread updateThread = null;
  private static Object lock = new Object();

  /**
   * Thread to process live update queues.
   * High priority items are processed first.
   */
  static class UpdateThread extends Thread {
    @Override
    public void run() {
      boolean queueHasData = false;
      synchronized(lock) {
        queueHasData = !highQueue.isEmpty() || !lowQueue.isEmpty();
      }
      while (queueHasData) {
        UpdateLine update;
        synchronized(lock) {
          update = !highQueue.isEmpty() ? highQueue.removeFirst() : lowQueue.removeFirst();
          queueHasData = !highQueue.isEmpty() || !lowQueue.isEmpty();
        }
        //Do stuff with update        
      }
      updateThread = null;
    }
  }

  /**
   * Adds the live update to a queue to be processed.
   * If the queue is full, the update may be ignored.
   *
   * @param appender The machine who sent these lines
   * @param lines The lines the machine sent. (Can be tray file or machine log lines)
   */
  synchronized public static void updateKPIWithMachineLines(AppenderID appender,
    String fileName, Date fileDate, LinkedList < String > lines) throws ParseException, SQLException {
    for (String line: lines) {
      if (line.startsWith("something...")) {
        synchronized(lock) {
          if (highQueue.size() < MAX_QUEUE_SIZE) {
            highQueue.add(new UpdateLine(appender, fileName, fileDate, line));
          } else {
            TLSystemAction.log("Live updates high priority queue full", appender);
          }
        }
      } else {
        synchronized(lock) {
          if (lowQueue.size() < MAX_QUEUE_SIZE) {
            lowQueue.add(new UpdateLine(appender, fileName, fileDate, line));
          } else {
            TLSystemAction.log("Live updates low priority queue full", appender);
          }
        }
      }
    }

    if (updateThread == null) {
      updateThread = new UpdateThread();
      updateThread.start();
    } else if (!updateThread.isAlive()) {
      updateThread.interrupt();
      updateThread = new UpdateThread();
      updateThread.start();
    }
  }