public interface AsyncTaskCompletedListener {
        public void OnResultSucceeded(String result);
    }

    public class LoginAsyncTask extends AsyncTask<String, Void, String> {
        AsyncTaskCompletedListener mAsyncTaskCompletedListener;

        @Override
        protected String doInBackground(String... arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            // TODO Auto-generated method stub
            super.onPostExecute(result);

            mAsyncTaskCompletedListener.OnResultSucceeded(result);
        }
    }