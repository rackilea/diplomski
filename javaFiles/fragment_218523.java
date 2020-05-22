import java.util.*;

public class ThreadDeath{
    public ThreadDeath()
    {
        System.out.println("creating service");
        ExecutorService service = Executors.newFixedThreadPool(2);
        for ( int i=0; i < 5; i++){
            service.execute(new Runnable(){
                     public void run(){
                        int a=4, b = 0;
                        System.out.println("Thread Name before divide by zero:"+Thread.currentThread().getName());
                        System.out.println("a and b="+a+":"+b);
                        System.out.println("a/b:"+(a/b));

                     }
                });
        }
        service.shutdown();
    }
    public static void main(String args[]){
        ThreadDeath test = new ThreadDeath();
    }
}