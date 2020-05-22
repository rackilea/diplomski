public class MyActivity extends Activity {
    BackTask backTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // start AsyncTask
        backTask = new BackTask();
        backTask.execute();

    }

    @Override
    protected void onStart() {
        super.onStart();
        if (backTask.getStatus() == Status.FINISHED) {
            doAnimation();
        }
    }

    private void doAnimation() {
        // start animations
    }

    class BackTask extends AsyncTask<Void, Void, Void> {

        @Override
        protected Void doInBackground(Void... params) {
            // do web stuff
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            super.onPostExecute(result);

            // fetches data now start anim
            doAnimation();

        }

    }

}