boolean readSMS(Intent intent, int code) {
        try {
            Bundle bundle = intent.getExtras();
            if (bundle != null) {
                Object[] pdusObj = (Object[]) bundle.get("pdus");
                for (int i = 0; i < pdusObj.length; i++) {
                    SmsMessage currentMessage = SmsMessage.createFromPdu((byte[]) pdusObj[i]);
                    String phoneNumber = currentMessage.getDisplayOriginatingAddress();
                    String senderNum = phoneNumber;
                    String message = currentMessage.getDisplayMessageBody();
                    if (message.contains(String.valueOf(code)))
                        return true;
                }
            }
        } catch (Exception e) {
            Log.v("ranjapp", "Exception here " + e.toString());
            return false;
        }
        return false;
    }