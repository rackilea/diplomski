public class ReceiveAlarm extends BroadcastReceiver {


     @Override
     public void onReceive(Context context, Intent intent) {         
         context.startService(new Intent(context, InService.class));
     }
}