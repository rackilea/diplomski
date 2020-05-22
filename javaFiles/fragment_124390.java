public class A {
  public static void main(String args[]){
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Callable<String> worker = new FileUploadThread("thread");
    Future<String> workerTask = executorService.submit(worker);

    try {
        boolean isDone = workerTask.isDone();
        System.out.println("Task is done: " + isDone);

        //Wait untill task is executing
        String status = workerTask.get();

        System.out.println("Status: " + status);
        isDone = workerTask.isDone();
        System.out.println("Task is done: " + isDone);
    } catch (InterruptedException | ExecutionException e) {
        e.printStackTrace();
    }
    executorService.shutdown();
  }
}

class FileUploadThread implements Callable<String> {
  //has a parametrized constuctor
  public FileUploadThread(String thread) { }

  @Override
  public String call() throws Exception {
    for(int i=0; i<5; i++){
        System.out.println("executing..sleep for 1 sec...");
        Thread.sleep(1000);
    }
    return "DONE";
  }
}