@Override
public void onReceive(Context context, Intent intent) {

    String number = "unknown";
    StringBuilder message = new StringBuilder();
    long timestamp = 0;

    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
        SmsMessage[] msgs = Telephony.Sms.Intents.getMessagesFromIntent(intent);

        number = msgs[0].getDisplayOriginatingAddress();
        timestamp = msgs[0].getTimestampMillis();

        for (int i = 0; i < msgs.length; i++) {
            message.append(msgs[i].getDisplayMessageBody());
        }
    }
    else {
        Object[] pdus = (Object[]) intent.getSerializableExtra("pdus");
        for (int i = 0; i < pdus.length; i++) {
            byte[] pdu = (byte[]) pdus[i];
            SmsMessage msg = SmsMessage.createFromPdu(pdu);

            if (i == 0) {
                number = msg.getDisplayOriginatingAddress();
                timestamp = msg.getTimestampMillis();
            }

            message.append(msg.getDisplayMessageBody());
        }
    }

    String report = String.format("SMS from %s%nMessage : %s%nSent : %s",
                                  number,
                                  message.toString(),
                                  DateFormat.getDateTimeInstance()
                                            .format(new Date(timestamp)));

    ...
}