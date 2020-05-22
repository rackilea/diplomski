List<Future<?>> list = new ArrayList<Future<?>>();
for (int i = 0; i < objectArray.length; i++) {
    Future<?> task=threadPool.submit(new ThreadHandler(objectArray[i], i));
          // The i is used elsewhere
    list.add(task);
}
for(Future future : list){
   try{
       future.get();
   }catch(CancellationException cx){
   ...
   }catch(ExecutionException ex){
   ...
   }catch(InterruptedException ix){
   ...
   }

}