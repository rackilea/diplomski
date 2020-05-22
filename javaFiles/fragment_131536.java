/** Define AsyncTask Class */
public class LoadAsyn extends AsyncTask<Void, Void, Boolean> {
    @Override
    protected void onPreExecute(){}

    @Override
    protected void onProgressUpdate(Void[] values) {};

    @Override
    protected Boolean doInBackground(Void... params) {

        //In this block all operation to do in background

        return true;

    }

    @Override
    protected void onPostExecute(final Boolean success) {
        dialog.dismiss();
        //Operation to do after execution
    }

    @Override
    protected void onCancelled() {
        loadCompAsync = null;
    }
}
}