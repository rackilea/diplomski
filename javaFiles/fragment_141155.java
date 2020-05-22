private final Executor executor = 
    Executors.newFixedThreadPool(Math.min(listRequest.size(), 100),
                                 new ThreadFactory(){
               public Thread newThread(Runnable r){
                    Thread t = new Thread(r);
                    t.setDaemon(true);
                    return t;
               }
});