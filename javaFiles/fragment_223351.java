private final Semaphore semaphore = new Semaphore(10);//or however you want max queued at any given moment
ThreadPoolExecutor tp= new ThreadPoolExecutor(...){
      public void execute(Runnable r){
          semaphore.acquire();
          super.execute(r);
      }    
      public void afterExecute(Runnable r, Thread t){
         semaphore.release();  
         super.afterExecute(r,t);
      }
};