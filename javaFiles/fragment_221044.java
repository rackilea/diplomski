public class TimertestActivity extends Activity {
    Handler handler = new Handler();
    Runnable runnable = new Runnable() {
        public void run() {
            afficher();
        }
    };

    /** Called when the activity is first created. */

      @Override   
      public void onCreate(Bundle icicle) {   
        super.onCreate(icicle);   
        setContentView(R.layout.main);  
        runnable.run();
      }   

      public void afficher()
      {
          Toast.makeText(getBaseContext(),
                     "test",
                     Toast.LENGTH_SHORT).show();
          handler.postDelayed(runnable, 1000);
      }
}