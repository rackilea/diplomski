public class ProcessData implements ServletContextListener
{
    private static String message;
    private int counter = 0;

    Runnable run = new Runnable()
   {
        @Override
        public void run()
       {
            message = "counter: " + (counter++);
            System.out.println(message);
       }
   };

   @Override
   public void contextInitialized(ServletContextEvent arg0)
   {
       ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
       scheduler.scheduleAtFixedRate(run, 0, 1, TimeUnit.MINUTES);
   }

   @Override
   public void contextDestroyed(ServletContextEvent arg0)
   {
       // Empty method
   }

   public static String getStatus()
   {
       return message;
   } 
}