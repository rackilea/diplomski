java.util.*;

public class TimerDemo {
   public static void main(String[] args) {
      // creating timer task, timer
      TimerTask tasknew = new TimerScheduleFixedRate();
      Timer timer = new Timer();

      // scheduling the task at fixed rate
      timer.scheduleAtFixedRate(tasknew,new Date(),1000);      
   }
   // this method performs the task
   public void run() {
      System.out.println("working at fixed rate");      
   }    
}.

    import java.util.*;

    public class TimerDemo {
       public static void main(String[] args) {
          // creating timer task, timer
          TimerTask tasknew = new TimerScheduleFixedRate();
          Timer timer = new Timer();

          // scheduling the task at fixed rate
          timer.scheduleAtFixedRate(tasknew,new Date(),1000);      
       }
       // this method performs the task
       public void run() {
          System.out.println("working at fixed rate");      
       }    
    }