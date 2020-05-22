@Override
public void onReceive(final Context context, final Intent intent) {
//create a pending intend that you will pass to the Async task so you can tell the system when the Async Task finished so that it can recycle.
final PendingResult pendingResult = goAsync();
 AsyncTask<String, Integer, String> asyncTask = new AsyncTask<String,  Integer, String>() {
    @Override
    protected String doInBackground(String... params) {
        //put the network calling code in here

        // Must call finish() so the BroadcastReceiver can be recycled.
        pendingResult.finish();
        return data;
    }
};
asyncTask.execute();
 }