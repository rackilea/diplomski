public class SmsReceiver extends BroadcastReceiver {

private static final Uri SMS_INBOX_URI = Uri.parse("content://sms");

@Override
public void onReceive(Context context, Intent intent) {
    // TODO Auto-generated method stub
    String body = "";
    String number = "";

    Bundle bundle = intent.getExtras();
    SmsMessage[] msgs = null;
    if (bundle != null) {
        // ---retrieve the SMS message received---
        Object[] pdus = (Object[]) bundle.get("pdus");
        msgs = new SmsMessage[pdus.length];
        for (int i = 0; i < msgs.length; i++) {
            msgs[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
            body += msgs[i].getMessageBody().toString();
            number +=msgs[i].getOriginatingAddress();
        }
    }

    SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(context);
    String key=prefs.getString(context.getString(R.string.acc_key_key), "");

    if (body.trim().equals("#"+key)) {
        sendGPSCoordinates(context, number);
    } else if (body.trim().equals("?"+key)){
        sendResponces(context);
    }
    abortBroadcast();
}