final android.os.Handler handler = new android.os.Handler();
private Runnable runnable;
private final long DELAY = 3000; // how many milliseconds you want to wait


@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    // all your previous stuffs


    myButton.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {       
        if(runnable != null) {
          // in this case the user already clicked once at least
          handler.removeCallbacks(runnable);
        }

        runnable = new Runnable() {
          @Override    
          public void run() {
            //this code will run when user isn't clicking for the time you set before.
          }
        };
        handler.postDelayed(runnable, DELAY); 
      }
    });
}