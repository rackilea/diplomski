public class YourActivity extends Activity {

    private void signal(){
        LocalBroadcastManager.getInstance(YourActivity.this).registerReceiver(receiver, new IntentFilter("Your action name"));
        Intent yourAction = new Intent(YourActivity.this, YourIntentService.class);
        String string = "someData";
        yourAction .putExtra("KEY_WITH_URL", string);
        startService(yourAction);
    }

    private BroadcastReceiver receiver = new BroadcastReceiver() {

        @Override
        public void onReceive(Context context, Intent intent) {
            String string = intent.getStringExtra("KEY_WITH_ANSWER");
            //Do your code 

        }
    };

}