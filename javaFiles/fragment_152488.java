class TestRunnable implements Runnable
{
   public void run()
   {
      System.out.println("TestRunnable in " + Thread.currentThread().getName());
   }
}