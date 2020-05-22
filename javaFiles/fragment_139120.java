public static void sendSMS(Context context, String incomingNumber, String sms) {
        DateTimeFormatter dtfOut = DateTimeFormat.forPattern("YYYY-MM-dd HH:MM:SS");
        SmsManager smsManager = SmsManager.getDefault();                                      //send sms
        try {
            ArrayList<String> parts = smsManager.divideMessage(sms);
            smsManager.sendMultipartTextMessage(incomingNumber, null, parts, null, null);

            RecContDBHelper recContDBHelper = new RecContDBHelper(context);
            recContDBHelper.insertRecord(new ContactData("", incomingNumber, dtfOut.print(MutableDateTime.now())));
            Log.v("ranjith", "Sms to be sent is " + sms);
        } catch (Exception e) {
            Log.v("ranjith", e + "");
        }
    }