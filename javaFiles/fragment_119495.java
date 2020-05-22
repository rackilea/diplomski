final ExecutorService executorService = Executors.newSingleThreadExecutor();
    Future<?> future = null;
    try {
        future = executorService.submit(() -> {
            lookup(word);
        });
        future.get(2, TimeUnit.SECONDS);
    }catch(Exception e){
        if(future != null){
            future.cancel(true);
        }
        slowWordSet.add(word);     
    }