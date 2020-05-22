import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.Executors;


public class ExecutorEx{
    static class ThreadA implements Runnable{
        int id;
        public ThreadA(int id){
            this.id = id;
        }
        public void run(){
            //To simulate some work
            try{Thread.sleep(Math.round(Math.random()*100));}catch(Exception e){}
            // to show message
            System.out.println(this.id + "--Test Message" + System.currentTimeMillis());
        }
    }

    public static void main(String args[]) throws Exception{
        int poolSize = 10;
        ExecutorService pool = Executors.newFixedThreadPool(poolSize);
        int i=0;
        while(i<100){
            pool.submit(new ThreadA(i));
            i++;
        }
        pool.shutdown();
        while(!pool.isTerminated()){
            pool.awaitTermination(60, TimeUnit.SECONDS);
        }
    }
}