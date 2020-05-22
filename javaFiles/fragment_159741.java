//Create applicationContext
final ApplicationContext appContext = 

//register ashutdown hook on application context
Runtime.getRuntime().addShutdownHook(new Thread() {
   public void run() {
       appContext.close();
   }});