public class SmsBroadcastReceiver extends BroadcastReceiver {

    //Interface
    private static SmsListener smsListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        //Get data to a Bundle
        Bundle data = intent.getExtras();

        //PDUs represent received SMS message(s)
        assert data != null;
        Object[] pdus = (Object[]) data.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            //Reconstruct SMS message from pdus object
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);
            String sender = smsMessage.getDisplayOriginatingAddress();
            String messageBody = smsMessage.getDisplayMessageBody();

            //SmsListener's callback method
            smsListener.messageReceived(sender, messageBody);
        }
    }

    //Bind listener for the use in ScheduledRepliesService
    public static void bindListener(SmsListener listener) { smsListener = listener; }
}