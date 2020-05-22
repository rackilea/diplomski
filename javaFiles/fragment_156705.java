for (final Object x : list){
    List<Object> someList = getList();
    if (!Collections.isEmpty(someList)){
        ExecutorService executorService = Executors.newCachedThreadPool();
        List<Future<?>> futures = new ArrayList<Future<?>>();
        for (final Object n : someList){
            futures.add(executorService.submit(new Runnable(){
                @Override
                public void run(){
                    someOtherService.process(parameters)
                }
            }));
        }

        for (Future<?> f : futures){
             try {
                 f.get();
             } catch (InterruptedException | ExecutionException e) {
                 //do some logging
             }
        }
    }
}