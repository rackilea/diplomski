public interface Schedulable extends Runnable{
   //In case you need extra API. If not, you don't 
  //need this interface, just use Runnable instead.
}


public class ScheduleAtFixedRate implements Schedulable{
     public void run(){
         // run at fixed rate
     }
}


public class ScheduleAtVariableRate implements Schedulable{
     public void run(){
         // run at fixed rate
     }
}

public class ScheduledExecutorService{
    ...

    public void execute(Schedulable s){
         new Thread(s).start();
    }
    ...

}