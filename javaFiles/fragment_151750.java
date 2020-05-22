//Member variable
android.os.Handler customHandler;

public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.main);

      //Assign value
      customHandler = new android.os.Handler();
      customHandler.postDelayed(updateTimerThread, 0);
}


    private Runnable updateTimerThread = new Runnable() {
          public void run()
          {
            //USE the value
            customHandler.postDelayed(this, 1000);
          }
    };