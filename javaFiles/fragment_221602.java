public class MySingletonClass implements SomeInterface
{
   private ScheduledFuture<?> handle;
   private static ScheduledExecutorService executor;
   private static SomeInterface instance;

   public void readResponseMsg(Document responseXml)
   {
       resetTimer();
       //do stuff
   }

   /**
    * Creates the timer.
    */
   private void resetTimer()
   {
      if (handle != null)
      {
         handle.cancel(false);
      }
      handle = executor.schedule(this, 30l, TimeUnit.SECONDS);
   }


   /**
    * Initialize the static variables. Should only be called once per server
    * restart
    */
   private static void init()
   {
      try
      {
         executor = Executors.newSingleThreadScheduledExecutor();
         inited = true;
      }
      catch (Exception e)
      {
         ourLogger.error("Exception initializing ScheduleResultReader", e);
      }
   }

   public static SomeInterface getInstance()
   {
      if (instance == null)
      {
         instance = new MySingletonClass();
      }

      return instance;
   }

}