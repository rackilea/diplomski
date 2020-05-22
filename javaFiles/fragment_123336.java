Map<Future<?>, Task> futures = new HashMap<Future<?>, Task>()
while(!taskQueue.isEmpty()){
    Task task = taskQueue.poll();
    Future<?> future = executor.submit(task);
    futures.put(future, task);
}

for(Map.Entry<Future<?>, Task> entry : futures.entrySet()){

    try {
        entry.getKey().get();
    }
    catch(ExecutionException ex) {
        // record the failed task, so that it can be re-added to the queue 
        // you should add a retry counter because you want to prevent endless loops
        taskQueue.add(entry.getValue());
    }
    catch(InterrupredException ex){ 
        // thread interrupted, exit
        Thread.interrupt();
        return;
    }
}