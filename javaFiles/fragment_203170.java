package tests;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;


public class RunnableQueue 
{
    private long waitTime;
    private TimeUnit unit;

    ExecutorService e;

    public RunnableQueue(long waitTime, TimeUnit unit) {
        e = Executors.newSingleThreadExecutor();

        this.waitTime = waitTime;
        this.unit = unit;
    }

    public void submitTask(final Runnable r){
        e.submit(new Runnable(){
           public void run(){
               Thread t = new Thread(r);
               t.start();

               try {
                t.join();
                Thread.sleep(unit.toMillis(waitTime));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
           }
        });
    }

    public static void main(String[] args) {
        RunnableQueue runQueue = new RunnableQueue(3, TimeUnit.SECONDS);

        for(int i=1; i<11; i++)
        {
            runQueue.submitTask(new DownloadTask(i));
            System.out.println("Submitted task " + i);
        }

    }
}