//within some method
  class myFirstRunnableClass implements Runnable {
       public void run() {
            classWithMethodToFire.doSomething( parameter );
       }
  }
  class mySecondRunnableClass implements Runnable {
       public void run() {
            classWithMethodToFire.doSomethingElse( parameter );
       }
  }
  taskExecutor.execute(new myFirstRunnableClass());
  taskExecutor.execute(new mySecondRunnableClass());