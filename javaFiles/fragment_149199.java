public class MyActivity extends Activity {
    public interface AsyncTaskCompleteListener {
        public void onComplete(/* any data you want to share */);
    }

    ...

    private AsyncTaskCompleteListener myListener = new ...() {
        // do stuff with data
    }

    private MyAsyncTask extends AsyncTask<Something,Something,Something> {

         private AsyncTaskCompleteListener listener = null;
         public MyAsyncTask(AsyncTaskCompleteListener listener) {
             this.listener = listener;
         }

         protected void onPostExecute(Something result) {
             if(listener != null) {
                 listener.onComplete(/*params*/);
             }
         }
     }
 ...
 }