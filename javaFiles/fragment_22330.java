public static void main(String[] args) {
    ExecutorService executor = Executors.newFixedThreadPool(4);

    Future<?> future = executor.submit(new Runnable() {
        @Override
        public void run() {
            writeToDb();            //        <-- your job
        }
    });

    executor.shutdown();            //        <-- reject all further submissions

    try {
        future.get(8, TimeUnit.SECONDS);  //     <-- wait 8 seconds to finish
    } catch (InterruptedException e) {    //     <-- possible error cases
        System.out.println("job was interrupted");
    } catch (ExecutionException e) {
        System.out.println("caught exception: " + e.getCause());
    } catch (TimeoutException e) {
        future.cancel(true);              //     <-- interrupt the job
        System.out.println("timeout");
    }

    // wait all unfinished tasks for 2 sec
    if(!executor.awaitTermination(2, TimeUnit.SECONDS)){
        // force them to quit by interrupting
        executor.shutdownNow();
    }
}