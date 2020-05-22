import java.util.Timer;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Matrix {

 public boolean matrix = true;
 static int interval = 3;
 static Timer timer;
 private final ScheduledExecutorService scheduler =
       Executors.newScheduledThreadPool(1);

 public String activate() {
    String done = "";
    scheduleTimer();
    return done;
 }

 private void matrix() {
    while(matrix) {
        System.out.print((int) (Math.random()+0.5));
        pressEnterToContinue();
    }
 }

 public void scheduleTimer() {
    System.out.println("Starting in:");
    final Runnable timer = new Runnable() {
        public void run() { System.out.println(setInterval()); }
    };

    scheduler.scheduleAtFixedRate(timer, 1, 1, TimeUnit.SECONDS);

    try {
        scheduler.awaitTermination(1, TimeUnit.DAYS);
        matrix();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
 }

 private final int setInterval() {
    if (interval == 1) {
        scheduler.shutdown();
    }
    return interval--;
  }

  private void pressEnterToContinue() {
    try
    {
        System.in.read();
        matrix = false;
    }  
    catch(Exception e) {}  
 }

  public static void main(String[] args){
     Matrix mat = new Matrix();
     mat.activate();
  }
}