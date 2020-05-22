public class MyAsyncTask extends AsyncTask<Void, Void, Void> {
    private MyEventListener callback;

    public MyAsyncTask(MyEventListener cb) {
        callback = cb;
    }

    [...]

    @Override
    protected void onPostExecute(Void aVoid) {
        if(callback != null) {
            callback.onEventCompleted();
        }
    }
}