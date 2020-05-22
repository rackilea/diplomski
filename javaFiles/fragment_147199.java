public enum Logger {
    INSTANCE;   

   ExecutorService pool = Executors.newFixedThreadPool(4);

   public void log(String logType, String logData){
       //you internally create a instance of your runnable and not leave on caller to create instance

      pool.execute(new MyRunnable(logType, logData));
   }
}