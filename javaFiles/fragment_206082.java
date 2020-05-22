class DBThread extends Thread {
   private BlockingQueue<ResultSet> resultSets;
   public DBThread(BlockingQueue<ResultSet> resultSets) {
      this.resultSets = resultSets;
   }

   public void run() {
      try {
         resultSets.put(getResultsFromDB());  //resultSets.put() call will block if the queue is full
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private ResultSet getResultsFromDB() {
      ResultSet resultSet = fromDB();   //some method to get ResultSet from DB
      return resultSet;
   }
}

class PrinterThread extends Thread  {
   private BlockingQueue<ResultSet> resultSets;
   public PrinterThread(BlockingQueue<ResultSet> resultSets) {
      this.resultSets = resultSets;
   }

   public void run() {
      try {
         printLogs(resultSets.take());  //resultSets.take() call will block if the queue is empty
      } catch (InterruptedException e) {
         e.printStackTrace();
      }
   }

   private void printLogs(ResultSet resultSet) {
      //print rows
   }
}

class Main {

   public static void main(String[] args) {
      BlockingQueue<ResultSet> resultSets = new LinkedBlockingQueue<>(10);
      DBThread dbThread = new DBThread(resultSets);
      PrinterThread printerThread = new PrinterThread(resultSets);
      dbThread.start();
      printerThread.start();
   }
}