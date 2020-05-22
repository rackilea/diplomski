public class MyActivity extends Activity {
    ProgressDialog mProgressDialog;

    onCreate(...){
        mProgressDialog = new ProgressDialog();
    }

    private class MyAsyncTask extends AsyncTask<...> {
        ...
        onPreExecute(...){
            mProgressDialog.show();
        }

        onPostExecute(...){
            mProgressDialog.dismiss();
        }
    }

    private class MyAsyncTask2 extends AsyncTask<...> {
        ...
        onPreExecute(...){
            mProgressDialog.show();
        }

        onPostExecute(...){
            mProgressDialog.dismiss();
        }
    }