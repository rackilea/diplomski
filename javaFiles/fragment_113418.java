public class BackService extends IntentService
{

 Context context=this;

 //public Timer t=null;
 public BackService()
 {
 super("myintentservice");
 }

 @Override
 protected void onHandleIntent(Intent intent) 
 {
  try
  {
     PowerManager pm = (PowerManager) getSystemService(Context.POWER_SERVICE);
      wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "My Tag");
      wl.acquire();
        //..CPU will remain on during this section..

     //make our network connections, poll the server and retrive updates
   //Provide a notification if you want

    wl.release();//Release the powerlock
  }
}

}