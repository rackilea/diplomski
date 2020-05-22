public class YourActivity extends Activity {

private TextView txtResults;

....do activity stuff....

public static class RingTypeBroadcastReceiver extends BroadcastReceiver{

int counterCall = 0;
int counterIdleOrOffHook = 0;

   @Override
   public void onReceive(Context context, Intent intent) {
    if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING)) {
     String incomingNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
        counterCall = counterCall + 1;
    }
    if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
            TelephonyManager.EXTRA_STATE_IDLE)
            || intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(
                    TelephonyManager.EXTRA_STATE_OFFHOOK)) {
        counterIdleOrOffHook = counterIdleOrOffHook + 1;
    }

   //here you can set your text view. But check that it is not null first! 
   if(txtResults != null){
       txtResults.setText("whatever");
   }
  }
}