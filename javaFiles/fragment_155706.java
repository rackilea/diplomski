import java.util.Timer;
import java.util.TimerTask;

public class TimerEg {
   private static TimerTask myTask = null;
   public static void main(String[] args) {
      Timer timer = new Timer("My Timer", false);
      int count = 10;
      myTask = new MyTimerTask(count, new Runnable() {
         public void run() {
            System.exit(0);
         }
      });

      long delay = 1000L;
      timer.scheduleAtFixedRate(myTask, delay, delay);
   }
}

class MyTimerTask extends TimerTask {
   private int count;
   private Runnable doWhenDone;

   public MyTimerTask(int count, Runnable doWhenDone) {
      this.count = count;
      this.doWhenDone = doWhenDone;
   }

   @Override
   public void run() {
      count--;
      System.out.println("Count is: " + count);
      if (count == 0) {
         cancel();
         doWhenDone.run();
      }
   }

}