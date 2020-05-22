public void launch(){
        ListeningExecutorService pool = 
        MoreExecutors.listeningDecorator(Executors.newFixedThreadPool(threadNumber));

    while(true){
        Command newCommand = commandsQueue.take(); 
        final ListenableFuture<String> future = pool.submit(new CommandWorker(newCommand));
    }       
}