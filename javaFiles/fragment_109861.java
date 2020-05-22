public class RestartThreadTutorial {
public static void main(String args[]){
    ExecutorService executorService = Executors.newFixedThreadPool(5);
    Future<?> taskHandler = executorService.submit(new Task());
    //restart the task after 3 seconds.
    try{
        Thread.sleep(3000);
    }catch(InterruptedException e){
        //empty
    }
    taskHandler.cancel(true); //it will cancel the running thread
    if (taskHandler.isCancelled()==true){//check the thread is cancelled
        executorService.submit(new Task());//then create new thread..
    }
}

public static class Task implements Runnable{
    private int secondsCounter;
    @Override
    public void run(){
        while(true){
            System.out.println("Thread -"+Thread.currentThread().getName()+"elapsed - "+ (secondsCounter++) +"second");
            try{
                Thread.sleep(1000);
            }catch(InterruptedException e){
                e.printStackTrace();
                break;
            }
        }
    }
}
}