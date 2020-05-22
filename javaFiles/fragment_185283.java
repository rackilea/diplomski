//within some method
  taskExecutor.execute( new Runnable() {
       public void run() {
            classWithMethodToFire.doSomething( parameter );
       }
  });