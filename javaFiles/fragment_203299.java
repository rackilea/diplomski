public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {
    @Override
    protected Boolean doInBackground(Void... params) {
        ...
    }

    @Override
    protected void onPostExecute(final Boolean success) {
        pd.dismiss();

        ...
    }

    @Override
    protected void onCancelled() {
        pd.dismiss();

        ...
    }
}