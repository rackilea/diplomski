public class MyReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            String phonenumber = intent.getStringExtra(Intent.EXTRA_PHONE_NUMBER);
            Log.d("OutgoingCallReceiver",phonenumber);
            Log.d("OutgoingCallReceiver",intent.getExtras().toString());
        }
}