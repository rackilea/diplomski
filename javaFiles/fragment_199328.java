public class TimerDemo {

   private int ptr = -1;
   String[] myStringArray = {"H","e","l","l","o"};
   public static void main(String[] args) {

      final Timer timer = new Timer();

      // creating timer task, timer
      TimerTask task = new TimerTask() {

        @Override
        public void run() {
            // TODO Auto-generated method stub
             System.out.println(myStringArray[++ptr]); 
             if (ptr == 4) { timer.cancel(); }    
        }

    };          

      // scheduling the task at interval
      timer.scheduleAtFixedRate(tasknew,0, 1000);      
   }
}