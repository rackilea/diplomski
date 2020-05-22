public class Main{
    private int number = 0;

    public void someNonStaticMethod() {
      //some code
      // final int number = 0;

      numberLabel.setText(number);
      Timer t = new Timer();
      t.scheduleAtFixedRate(new TimerTask(){
           public void run(){
           //elapsed time
               number = number + 1;
           }

      }, 1000, 1000);
   }
}