public static void main(String[] args) 
{
  ShutdownHookThread shutdownHook = new ShutdownHookThread();
  Runtime.getRuntime().addShutdownHook(shutdownHook );
}

  private static class JVMShutdownHook extends Thread 
  {
   public void run() 
   {
   // tempDirectory.delete();
   }
  }