public static void main(String[] args) throws InterruptedException {
    final ExecutorService es = Executors.newSingleThreadExecutor();
    final Future<?> f = es.submit(new Runnable() {

        @Override
        public void run() {
            //do stuff
        }
    });
    try {
        //wait
        f.get();        
    } catch (ExecutionException ex) {
        //there was an exeception in the task
    }
}