public class YourIntentService extends IntentService {

    @Override
    protected void onHandleIntent(Intent intent) {
        // Download here

        Intent complete = new Intent ("Your action name");
        complete.putExtra("KEY_WITH_ANSWER", stringToReturn);
        LocalBroadcastManager.getInstance(YourIntentService.this).sendBroadcast(complete);

    }

}