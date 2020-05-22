ExecutorCompletionService<List<MyResult>> queue = new ExecutorCompletionService<List<MyResult>>(executor);

// do this in a loop
queue.submit(aCallable);

//after looping 
queue.take().get(); //take will block till all threads finish