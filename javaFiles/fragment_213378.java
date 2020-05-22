public class SmsController extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    this.c=context;
    SmsMessage msgs[] = null;
    Bundle bundle = intent.getExtras();
    try {
        Object pdus[] = (Object[]) bundle.get("pdus");
        msgs = new SmsMessage[pdus.length];
        for (int n = 0; n < pdus.length; n++) {
            byte[] byteData = (byte[]) pdus[n];
            msgs[n] = SmsMessage.createFromPdu(byteData);
        }
    } catch (Exception e) {

    }
    for (int i = 0; i < msgs.length; i++) {
        String message = msgs[i].getDisplayMessageBody();
        if (message != null && message.length() > 0) {
            String from = msgs[i].getOriginatingAddress();
            if(message.contains("your code")){
                if(message.contains("MAC ADRESSE")){
                    controlRemotePC();
                } 
            }
        }
    }
    abortBroadcast();
}
}