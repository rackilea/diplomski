class Main extends Application {
   public static Log  log = new Log("main.log");   // class, not shown here
   Work work;
   public start() // entry point
   {
       work = new Work();
   }
}