public void testThread()
{

   //create a callable for each method
   Callable<Void> callable1 = new Callable<Void>()
   {
      @Override
      public Void call() throws Exception
      {
         method1();
         return null;
      }
   };

   Callable<Void> callable2 = new Callable<Void>()
   {
      @Override
      public Void call() throws Exception
      {
         method2();
         return null;
      }
   };

   Callable<Void> callable3 = new Callable<Void>()
   {
      @Override
      public Void call() throws Exception
      {
         method3();
         return null;
      }
   };

   //add to a list
   List<Callable<Void>> taskList = new ArrayList<Callable<Void>>();
   taskList.add(callable1);
   taskList.add(callable2);
   taskList.add(callable3);

   //create a pool executor with 3 threads
   ExecutorService executor = Executors.newFixedThreadPool(3);

   try
   {
      //start the threads and wait for them to finish
      executor.invokeAll(taskList);
   }
   catch (InterruptedException ie)
   {
      //do something if you care about interruption;
   }

}

private void method1()
{
   System.out.println("method1");
}

private void method2()
{
   System.out.println("method2");
}

private void method3()
{
   System.out.println("method3");
}