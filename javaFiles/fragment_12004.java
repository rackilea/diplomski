public class IncomingSms extends BroadcastReceiver {

    String p,m;

    final SmsManager sms = SmsManager.getDefault();

    public void onReceive(Context context, Intent intent) {

        Bundle extras = intent.getExtras();

        if (extras != null) {
            Object[] smsExtra = (Object[]) extras.get( "pdus" );
            ContentResolver contentResolver = context.getContentResolver();

            for (int i = 0; i < smsExtra.length; ++i) {

                SmsMessage sms = createFromPdu( (byte[]) smsExtra[i] );

                String phoneNumber = sms.getDisplayOriginatingAddress();
                String message = sms.getDisplayMessageBody();

                try {
                    if (phoneNumber.contains( "+92xxxxxxxxxx" )) {   //add phone number
                        int duration = Toast.LENGTH_LONG;
                        DBQueries dbQueries = new DBQueries();
                        dbQueries.save(phoneNumber, message);
                        Toast toast = Toast.makeText( context,
                                "senderNum: " + phoneNumber + ", message: " + message, duration );
                        toast.show();

                        p=phoneNumber;
                        m=message;

                    }
                } catch (Exception e) {
                }

            }
        }
    }
}