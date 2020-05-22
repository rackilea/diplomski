public class OnLockReceive extends BroadcastReceiver {  
  @Override
  public void onReceive(Context context, Intent intent) {
    ((DevicePolicyManager)context.getSystemService(Context.DEVICE_POLICY_SERVICE)).lockNow();
  } 
}