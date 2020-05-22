public class ExampleTask extends AsyncTask<Void, Void, Boolean> {

    public interface TaskListener {
        public void onFinished(boolean success);
    }

    private final TaskListener listener;

    private ExampleTask(TaskListener listener) {
        this.listener = listener;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        boolean result = doWork();

        return result;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);

        if(this.listener != null) {
            this.listener.onFinished(result);
        }
    }
}