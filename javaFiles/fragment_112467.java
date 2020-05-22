ExecutorService executorService = Executors.newCachedThreadPool();
    Future future = null;
    for(final String link : links)
    {
        future = executorService.submit(new Runnable(){

        @Override
        public void run(){
            try{
               Analyzer.process(link);
            }
            catch( Exception e ){
                e.printStackTrace();
            }

        }
    });

        while(future != null
                && !future.isDone()
                && !future.isCancelled())
        {
            try {
                Thread.sleep(2000); // Or do something else
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    executorService.shutdown();