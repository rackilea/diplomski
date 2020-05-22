public class IncomingSms extends BroadcastReceiver {
    // Get the object of SmsManager
    final SmsManager sms = SmsManager.getDefault();
    public void onReceive(Context context, Intent intent) {
        // Retrieves a map of extended data from the intent.
        final Bundle bundle = intent.getExtras();
        SmsMessage messages = null;
        try {
            if (bundle != null) {
                final Object[] pdusObj = (Object[]) bundle.get("pdus");
                messages = new SmsMessage[pdus.length];
                for (int i = 0; i < pdusObj.length; i++) {
                    messages[i] = SmsMessage.createFromPdu((byte[]) pdusObj[i]);

                   } // end for loop
            } // bundle is null
        } catch (Exception e) {
            Log.e("SmsReceiver", "Exception smsReceiver" +e);
        }
        SmsMessage sms = messages[0];
        String message;
        try {
            if (messages.length == 1 || sms.isReplace()) {

                String phoneNumber = sms.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                     message = sms.getMessageBody();
                    Log.info("SmsReceiver", "senderNum: " + senderNum + "; message: " + message+"; Date="+sms.getTimestampMillis());
//sending to API
            } else {
            StringBuilder bodyText = new StringBuilder();
            for (int j = 0; j < messages.length; j++) {
                bodyText.append(messages[j].getMessageBody());
            }
            message = bodyText.toString();
        }
        } catch (Exception e) {

        }

    }
}