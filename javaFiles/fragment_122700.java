public class MyService : Service
{
  internal const string CONNECTIVITY_CHANGE_ACTION = "android.net.conn.CONNECTIVITY_CHANGE";
  internal NotificationManager manager;

  public override IBinder onBind(Intent intent)
  {
    return null;
  }

  public override int onStartCommand(Intent intent, int flags, int startId)
  {
    // Let it continue running until it is stopped.
    Toast.makeText(this, "Service Started", Toast.LENGTH_LONG).show();
    IntentFilter filter = new IntentFilter();
    filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
    BroadcastReceiver receiver = new BroadcastReceiverAnonymousInnerClass();
    registerReceiver(receiver,filter);
    return START_STICKY;
  }

  private class BroadcastReceiverAnonymousInnerClass : BroadcastReceiver
  {
      public override void onReceive(Context context, Intent intent)
      {
          string action = intent.Action;
          if (CONNECTIVITY_CHANGE_ACTION.Equals(action))
          {
              //check internet connection
              if (!ConnectionHelper.isConnectedOrConnecting(context))
              {
                  if (context != null)
                  {
                      bool show = false;
                      if (ConnectionHelper.lastNoConnectionTs == -1)
                      { //first time
                          show = true;
                          ConnectionHelper.lastNoConnectionTs = DateTimeHelper.CurrentUnixTimeMillis();
                      }
                      else
                      {
                          if (DateTimeHelper.CurrentUnixTimeMillis() - ConnectionHelper.lastNoConnectionTs > 1000)
                          {
                              show = true;
                              ConnectionHelper.lastNoConnectionTs = DateTimeHelper.CurrentUnixTimeMillis();
                          }
                      }

                      if (show && ConnectionHelper.isOnline)
                      {
                          ConnectionHelper.isOnline = false;
                          Log.i("NETWORK123","Connection lost");
                          //manager.cancelAll();
                      }
                  }
              }
              else
              {
                  Log.i("NETWORK123","Connected");
                  showNotifications("APP", "It is working");
                  // Perform your actions here
                  ConnectionHelper.isOnline = true;
              }
          }
      }
  }

  public override void onDestroy()
  {
    base.onDestroy();
    Toast.makeText(this, "Service Destroyed", Toast.LENGTH_LONG).show();
  }
}

internal static class DateTimeHelper
{
    private static readonly System.DateTime Jan1st1970 = new System.DateTime(1970, 1, 1, 0, 0, 0, System.DateTimeKind.Utc);
    public static long CurrentUnixTimeMillis()
    {
        return (long)(System.DateTime.UtcNow - Jan1st1970).TotalMilliseconds;
    }
}