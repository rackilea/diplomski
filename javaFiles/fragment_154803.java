public class PollerService extends Service {
    final String TAG = "PollerService";
    @Override
    public void onStart(Intent intent, int startId) {
    Log.i(TAG, "Service onStart()");
    pollingTask.execute();
}

AsyncTask<Void, Void, Void> pollingTask = new AsyncTask<Void, Void, Void>() {
    @Override
    protected Void doInBackground(Void... param) {
        // Do what you want in the background
    }

    @Override
    protected void onPostExecute(Void result) {
        stopSelf();
    }
};
}