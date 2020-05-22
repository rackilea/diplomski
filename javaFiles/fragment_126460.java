public class MyActivity extends Activity  {

   CountDownTimer thetimer;

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      thetimer = new myTimer(millisInFuture, 1000);
   }

   public void onClick(View v) {
      Random rand = new Random();
      switch(v.getId()) {
         case R.id.buttonstart:
            btnstart.setVisibility(View.INVISIBLE);     
            thetimer.start();   
            break;

         case R.id.imageView1:       
            if (thetimer != null) {
               thetimer.cancel();
               thetimer = new myTimer(countdownPeriod + 3000, 1000).start();
            }
            break;
      }   
   }    
}