PendingIntent pi;
BroadcastReceiver br;
Intent myIntent;

 @Override
  public void onCreate()
  {
    super.onCreate();

     myIntent = new Intent("something")


   if(Build.Version.SDK_INT >= 16)     //The flag we used here was only added at API 16    
    myIntent.setFlags(Intent.FLAG_RECEIVER_FOREGROUND);
    //use myIntent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND); if you want to add more than one flag to this intent;

    pi = PendingIntent.getBroadcast(context, 1, myIntent, 0); 

    br = new BroadcastReceiver ()
    {
      public void onReceive (Context context, Intent i) {
        new thread(new Runnable()
        {
          public void run()
          {
            //do something
          }
        }).start();
      }
    };