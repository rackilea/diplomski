public class OutCallLogger extends BroadcastReceiver {

    private static boolean noCallListenerYet = true;

    @Override
    public void onReceive(final Context context, Intent intent) {
        number = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
        if (noCallListenerYet) {
            final TelephonyManager tm = (TelephonyManager) context.getSystemService(
                    Context.TELEPHONY_SERVICE);
            tm.listen(new PhoneStateListener() {
                @Override
                public void onCallStateChanged(int state, String incomingNumber) {
                    switch (state) {
                        case TelephonyManager.CALL_STATE_RINGING:
                            Log.d(This.LOG_TAG, "RINGING");
                            break;
                        case TelephonyManager.CALL_STATE_OFFHOOK:
                            Log.d(This.LOG_TAG, "OFFHOOK");
                            break;
                        case TelephonyManager.CALL_STATE_IDLE:
                            Log.d(This.LOG_TAG, "IDLE");
                            break;
                        default:
                            Log.d(This.LOG_TAG, "Default: " + state);
                            break;
                    }
                }
            }, PhoneStateListener.LISTEN_CALL_STATE);
            noCallListenerYet = false;
        }
    }