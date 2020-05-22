import java.util.Timer;
 import java.util.TimerTask;
 public class newClass extends TimerTask{
      int i = 10;
      static Timer timer;

      @Override
      public void run(){
           System.out.println("hello");
           i--;
           if (i == 0)
               timer.cancel();

      }

      public static void main(String[] args){
           TimerTask timerTask = new newClass();
           timer = new Timer(false);
           timer.scheduleAtFixedRate(timerTask, 0, 5 * 1000);
      }
 }