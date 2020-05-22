import java.util.Timer;
import java.util.TimerTask;

...

Timer timer = new Timer();
timer.schedule(new TimerTask() { 
   @Override  
   public void run() {
       System.out.println("delayed hello world");
   }
},  45000);