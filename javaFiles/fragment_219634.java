List<Future<T>> futures = new ArrayList<>(10);
  for(int i = 0; i < 10; i++){
    futures.add(pool.submit(new MyTask()));  
  }  

  T result;  
  for(Future<T> f: futures)
     result = f.get(); // get the result