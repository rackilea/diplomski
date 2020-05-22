int numFiles = 20;
int threads = 4;

ExecutorService exec = Executors.newFixedThreadPool(threads);

for(int i = 0; i < numFiles; i++){
    String[] fileContents = // read current file;
    exec.submit(new ThreadTask(fileContents));
}

exec.shutdown();
exec.awaitTermination(Long.MAX_VALUE, TimeUnit.SECONDS);
...

class ThreadTask implements Runnable {

   private String[] fileContents;

   public ThreadTask(String[] fileContents) {
        this.fileContents = fileContents;
   }

   public void run(){
      //processes txt file
   }
}