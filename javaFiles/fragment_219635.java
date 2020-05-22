for(int i = 0; i < 10; i++){
     pool.submit(new MyTask());
   }
  for(int i = 0; i < 10; i++){
      T result = pool.take().get();

   //your another code
  }