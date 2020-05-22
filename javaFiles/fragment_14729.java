private BroadcastReceiver mCallBroadcastReceiver = new BroadcastReceiver()
{
    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("RECEIVER X: ", "IS UP AGAIN....");
        String action = intent.getAction();
        String PhoneNumber = "UNKNOWN";

        if (action.equalsIgnoreCase("android.intent.action.NEW_OUTGOING_CALL"))
        {
            PhoneNumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.d("RECEIVER X: ", "Outgoing number : " + PhoneNumber);
            Intent InsertDb = new Intent(context, CatchNumbers.class);
            InsertDb.putExtra("TYPE", "OUTGOING");
            InsertDb.putExtra("PHONENUMBER", PhoneNumber);
            startService(InsertDb);
        }
        if (action.equalsIgnoreCase("android.intent.action.PHONE_STATE"))
        {
            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_RINGING))
            {
                PhoneNumber = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);
                Log.d("RECEIVER X: ", "Incoming number : " + PhoneNumber);
                Intent InsertDb = new Intent(context, CatchNumbers.class);
                InsertDb.putExtra("TYPE", "INCOMING");
                InsertDb.putExtra("PHONENUMBER", PhoneNumber);
                startService(InsertDb);
            }
            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_IDLE))
            {
                Log.d("RECEIVER X: ", "CALL ENDED... ");
                // start service to send SMS now from Table
                Intent InsertDb = new Intent(context, CatchNumbers.class);
                InsertDb.putExtra("TYPE", "CALLEND");
                startService(InsertDb);
            }
            if (intent.getStringExtra(TelephonyManager.EXTRA_STATE).equals(TelephonyManager.EXTRA_STATE_OFFHOOK))
            {
                Log.d("RECEIVER X: ", "ACTIVE OUTGOING CALL : ");
            }
        }
    }
};