public class AlertOnProximityReceiver extends BroadcastReceiver {
  @Override
  public void onReceive(final Context context, final Intent intent) {
    Boolean getting_closer = intent.getBooleanExtra(LocationManager.KEY_PROXIMITY_ENTERING, false);
    if (getting_closer)
      Log.d("Radius", "Hey, I just entered your radius!");
    else
      Log.d("Radius", "I just exited your radius!");
  }          
}